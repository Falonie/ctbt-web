package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.SensitiveArea;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.SensitiveAreaService;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipsServiceImplTest {
    @Resource
    private ShipsService shipsService;
    @Resource
    private SensitiveAreaService sensitiveAreaService;

    @Test
//    @Transactional
    public void save() {
        Ships ships = new Ships();
        ships.setName("FalonieShip");
        ships.setNumber("FalonieShip");
//        ships.setName("testShip");
//        ships.setNumber("testShip");
        ships.setMmsi("10000");
        ships.setShipType("123");
        ships.setCallSign("9VJJ7");
        ships.setLatitude(28.6938333333333);
        ships.setLongitude(121.453183333333);
        ships.setSpeed(9.8);
        ships.setShipLength(100.5);
        ships.setIsUnpower("1");
        ships.setDraught(0);
        ships.setDestination("ZHOUSHAN");
        ships.setReceiveDate(new Date());
        ships.setPositionDate(new Date());
        List<SensitiveArea> sensitiveAreaList = new ArrayList<>();
        sensitiveAreaList.add(sensitiveAreaService.findByAreaIdOrAreaName(833, ""));
//        sensitiveAreaList.add(sensitiveAreaService.findByAreaIdOrAreaName(867, ""));
        ships.setSensitiveAreaList(sensitiveAreaList);
        Ships result = shipsService.save(ships);
        assertNotNull(result);
    }

    @Test
    @Transactional
    public void update() {
        Ships ships = shipsService.findById(582545);
    }

    @Test
    public void findById() {
        Ships ships = shipsService.findById(483015);
        assertNotNull(ships);
    }

    @Test
    public void findByName() {
        Ships ships = shipsService.findByName("ZHEPUYU19236");
        assertNotNull(ships);
    }

    @Test
    public void findByIdOrName() {
//        Ships ships = shipsService.findByIdOrName(0, "ZHEPUYU19236");
        Ships ships = shipsService.findByIdOrName(467918, "XXXXXXXXXXXXXXXXXXXXX");
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

    @Test
    public void findByNationLikeOrProvinceLikeOrCityLikeAndUserId() {
        PageRequest request = PageRequest.of(499, 10);
        Page<Ships> shipsPage2 = shipsService.findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId("中国",
                "浙", "舟", "普", 122, request);
        assertNotEquals(0, shipsPage2.getTotalElements());
    }
}