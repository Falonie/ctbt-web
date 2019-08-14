package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipsToUsersServiceImplTest {
    @Resource
    private ShipsToUsersService shipsToUsersService;

    @Test
    public void findByUserId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipsToUsers> shipsToUsersPage = shipsToUsersService.findByUserId(122, request);
        assertNotEquals(0, shipsToUsersPage.getTotalElements());
    }
}