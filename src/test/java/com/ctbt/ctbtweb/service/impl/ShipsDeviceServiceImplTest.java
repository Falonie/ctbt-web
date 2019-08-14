package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.ShipsDevice;
import com.ctbt.ctbtweb.service.ShipsDeviceService;
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
public class ShipsDeviceServiceImplTest {
    @Resource
    private ShipsDeviceService shipsDeviceService;

    @Test
    public void findByShipsDeviceId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipsDevice> shipsDevicePage = shipsDeviceService.findByShipsDeviceId("356170", request);
        System.out.println("**********" + shipsDevicePage.getContent() + "**********");
        assertNotEquals(0, shipsDevicePage.getTotalElements());
    }

    @Test
    public void findByShipsId() {
//        Ships ships=
    }
}