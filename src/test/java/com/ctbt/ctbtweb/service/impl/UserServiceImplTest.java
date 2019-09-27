package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
//    @Transactional
    public void save() {
        User user = new User();
        user.setUsername("Durant");
//        user.setPassword("10000");
        user.setPassword(bCryptPasswordEncoder.encode("10000"));
        user.setCreateTime(new Date());
        User result = userService.save(user);
        System.out.println("********" + user + "********");
        assertNotNull(result);
    }

    @Test
    public void findById() {
        User user = userService.findById(1097);
        assertNotNull(user);
    }

    @Test
    public void findByUsernameAndPassword() {
//        User user = userService.findByUsernameAndPassword("testUser","10000");
        User user = userService.findByUsernameAndPassword("testUser", "$2a$10$Pew8cCMfxsq10eAhCVcZhuQBklryiCfyqEKcIqUbLgllusyY3asXu");
        assertNotNull(user);
    }

    @Test
    @Transactional
    public void update() {
        User user = userService.findById(1444);
        user.setUsername("XXXXXXXXXX");
        User result = userService.save(user);
//        assertNotNull(result);
        assertEquals("XXXXXXXXXX", result.getUsername());
    }

    @Test
//    @Transactional
    public void delete() {
        User user = userService.findById(854);
        userService.delete(user);
        assertNull(userService.findById(854));
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<User> userPage = userService.findAll(request);
        System.out.println("*********" + userPage.getTotalElements() + "********");
        assertNotEquals(0, userPage.getTotalElements());
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("falonie");
        assertNotNull(user);
    }

    @Test
    public void login() {
        ServerResponse<User> userServerResponse = userService.login("falonie", "10000");
//        assertEquals(new Integer(200), userServerResponse.getCode());
        assertEquals(200, userServerResponse.getCode());
    }

    @Test
    public void verifyPassword() {
        User user = userService.findByUsername("falonie");
//        assertNotNull(user);
        assertTrue(bCryptPasswordEncoder.matches("10000", user.getPassword()));
    }

    @Test
    public void checkValid() {
        ServerResponse response = userService.checkValid("falonie");
        assertEquals(400, response.getCode());
    }
}