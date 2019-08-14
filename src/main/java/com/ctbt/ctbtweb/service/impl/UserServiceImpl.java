package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.dao.UserDao;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.UserForm;
import com.ctbt.ctbtweb.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String name) {
        return userDao.findByUsername(name);
    }

    @Override
    public User findByIdOrUsername(int id, String username) {
        return userDao.findByIdOrUsername(id, username);
    }

    @Override
    public User findByUsernameAndPassword(String name, String password) {
        return userDao.findByUsernameAndPassword(name, password);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userPage = userDao.findAll(pageable);
        return new PageImpl<User>(userPage.getContent(), pageable, userPage.getTotalElements());
    }

    @Override
    public ServerResponse<User> register(UserForm userForm) {
        User u = userDao.findByUsername(userForm.getUsername());
        if (u != null) {
            return ServerResponse.failByMsg("用户名已被注册");
        }
        if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            return ServerResponse.failByMsg("两次密码不一致");
        }
        User user1 = new User();
        user1.setUsername(userForm.getUsername());
        user1.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        User result = userDao.save(user1);
        return ServerResponse.success(result);
    }

    @Override
    public ServerResponse<User> login(String name, String password) {
        if (name.equals("") || password.equals("")) {
            return ServerResponse.failByMsg("用户名或密码不能为空");
        }
        User user = userDao.findByUsername(name);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return ServerResponse.failByMsg("密码错误");
        }
        return ServerResponse.success("登录成功", user);
    }

    @Override
    public ServerResponse<String> resetPassword(String oldPassword, String newPassword, String confirmPassword, User user) {
        if (!bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            return ServerResponse.failByMsg("旧密码错误");
        }
        if (!newPassword.equals(confirmPassword)) {
            return ServerResponse.failByMsg("两次密码不一致");
        }
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        User updateUser = userDao.save(user);
        if (updateUser == null) {
            return ServerResponse.failByMsg("密码修改失败");
        }
        return ServerResponse.successByMsg("密码修改成功");
    }

    @Override
    public ServerResponse checkValid(String str) {
        User user = userDao.findByUsername(str);
        if (user != null) {
            return ServerResponse.failByMsg("该用户名已存在");
        }
        return ServerResponse.successByMsg("校验成功");
    }

    @Override
    public ServerResponse editProfile(User user) {
        ServerResponse response = this.checkValid(user.getUsername());
        if (response.getCode() != 200) {
            return response;
        }
        return ServerResponse.successByMsg("修改成功");
    }

}
