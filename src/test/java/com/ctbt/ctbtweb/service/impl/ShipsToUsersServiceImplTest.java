package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

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

    @Test
    public void save() {
        ShipsToUsers shipsToUsers=new ShipsToUsers();
        shipsToUsers.setId(3014603);
        shipsToUsers.setShipId(1753058);
        shipsToUsers.setUserId(122);
        shipsToUsers.setUpdateEquipmentIdDate(new Date());
        ShipsToUsers result=shipsToUsersService.save(shipsToUsers);
        assertNotNull(result);
    }
}