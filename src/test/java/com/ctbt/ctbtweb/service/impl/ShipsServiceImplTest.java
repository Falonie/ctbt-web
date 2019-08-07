package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.domain.Ships;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipsServiceImplTest {
    @Resource
    private ShipsService shipsService;

    @Test
    @Transactional
    public void save() {
        Ships ships = new Ships();
        ships.setName("testShip");
        ships.setNumber("testShip");
        ships.setMmsi("10000");
    }

    @Test
    @Transactional
    public void update() {
        Ships ships = shipsService.findById(582545);
    }

    @Test
    public void findById() {
        Ships ships = shipsService.findById(582545);
        assertNotNull(ships);
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<Ships> shipsPage = shipsService.findAll(request);
        assertNotEquals(0, shipsPage.getTotalElements());
    }

    @Test
    public void findByDeviceId() {
    }

    @Test
    @Transactional
    public void delete() {
    }
}