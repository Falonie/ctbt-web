package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.dao.UserDao;
import com.ctbt.ctbtweb.domain.User;
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
}
