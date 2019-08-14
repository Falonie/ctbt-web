package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.ShipType;
import com.ctbt.ctbtweb.service.ShipTypeService;
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
public class ShipTypeServiceImplTest {
    @Resource
    private ShipTypeService shipTypeService;

    @Test
    public void findById() {
        ShipType shipType = shipTypeService.findById(18);
        assertNotNull(shipType);
    }

    @Test
    public void findByName() {
        ShipType shipType = shipTypeService.findByName("渔运船");
        assertNotNull(shipType);
    }

    @Test
    public void findByIdOrTypeName() {
//        ShipType shipType = shipTypeService.findByIdOrTypeName(0,"渔运船");
        ShipType shipType = shipTypeService.findByIdOrTypeName(181,"erwerqwrf");
        assertNotNull(shipType);
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipType> shipTypePage = shipTypeService.findAll(request);
        assertNotEquals(0, shipTypePage.getTotalElements());
    }
}