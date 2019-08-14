package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.Constant;
import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.ResetPasswordForm;
import com.ctbt.ctbtweb.forms.EditUserForm;
import com.ctbt.ctbtweb.forms.UserForm;
import com.ctbt.ctbtweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ServerResponse register(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return userService.register(userForm);
    }

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestParam(value = "username", defaultValue = "") String username,
                                      @RequestParam(value = "password", defaultValue = "") String password,
                                      HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.getCode() == 200) {
            session.setAttribute(Constant.CURRENT_USER, response.getData());
            System.out.println("*********" + response.getData() + "*********");
        }
        return response;
    }

    @GetMapping
    public ServerResponse findUser(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
//        User user = userService.findByUsername(username);
        User user = userService.findByIdOrUsername(id, username);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        return ServerResponse.success(user);
    }

    @GetMapping("/list")
    public ServerResponse userList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, 10);
        Page<User> userPage = userService.findAll(request);
        return ServerResponse.success(userPage.getContent());
    }

    @PutMapping("/changePassword")
    public ServerResponse resetPassword(@RequestParam("id") int id, @Valid ResetPasswordForm passwordForm, BindingResult bindingResult, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return userService.resetPassword(passwordForm.getOldPassword(), passwordForm.getNewPassword(), passwordForm.getConfirmPassword(), user);
    }

    @PutMapping("/editProfile")
    public ServerResponse editProfile(@RequestParam("id") int id, @Valid EditUserForm editUserForm, BindingResult bindingResult, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(editUserForm, user);
        if (userService.findByUsername(editUserForm.getUsername()) != null) {
            return ServerResponse.failByMsg("该用户名已存在");
        }
        User result = userService.save(user);
        return ServerResponse.successByMsg("修改成功");
    }

    public ServerResponse checkValid(String str) {
        User user = userService.findByUsername(str);
        if (user != null) {
            return ServerResponse.failByMsg("该用户名已存在");
        }
        return ServerResponse.successByMsg("校验成功");
    }

    @DeleteMapping("/delete")
    public ServerResponse deleteUser(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        User user = userService.findByIdOrUsername(id, username);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        try {
            userService.delete(user);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            return ServerResponse.successByMsg("删除失败");
        }
    }
}
