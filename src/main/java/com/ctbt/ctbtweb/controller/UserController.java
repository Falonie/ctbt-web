package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.domain.User;
import com.ctbt.ctbtweb.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestParam(value = "username",defaultValue = "") String username,
                                      @RequestParam(value = "password",defaultValue = "") String password) {
        return userService.login(username, password);
    }

//    @GetMapping("/list")
//    public ServerResponse userList(@RequestParam(value = "page", defaultValue = "0") Integer page,
//                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
//        PageRequest request = PageRequest.of(page, 10);
//        Page<User> userPage = userService.findAll(request);
//        return ServerResponse.success(userPage.getContent());
//    }
}
