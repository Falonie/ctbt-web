package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.AlarmToUser;
import com.ctbt.ctbtweb.service.AlarmToUserService;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@Component
public class AlarmToUserServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private AlarmToUserService alarmToUserService;

    @Test
    public void findAllByUserId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<AlarmToUser> alarmToUserPage = alarmToUserService.findAllByUserId(122, request);
        System.out.println("alarmToUserPage" + alarmToUserPage.getTotalElements());
        assertNotEquals(0, alarmToUserPage.getTotalElements());
    }
}