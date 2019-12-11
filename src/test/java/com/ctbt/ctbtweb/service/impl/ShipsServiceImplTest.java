package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import com.ctbt.ctbtweb.service.UserService;
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
    private AlarmAreaService alarmAreaService;
    @Resource
    private UserService userService;
    @Resource
    private ShipsToUsersService shipsToUsersService;

    @Test
//    @Transactional
    public void save() {
        Ships ships = new Ships();
//        ships.setId(1111111111);
        ships.setName("falonieShip2");
//        ships.setNumber("falonieShip");
//        ships.setName("testShip");
//        ships.setNumber("testShip");
        ships.setProductId("AC0004");
        ships.setEquipmentId("22222224");
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
//        AlarmArea alarmArea = alarmAreaService.findByAreaIdOrAreaName(833, "");
//        List<AlarmArea> alarmAreaList = new ArrayList<>();
//        alarmAreaList.add(alarmArea);
//        alarmAreaList.add(alarmAreaService.findByAreaIdOrAreaName(867, ""));
//        ships.setSensitiveAreaList(alarmAreaList);

        User user = userService.findById(856);
        System.out.println("****user******" + user);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        ships.setUserList(userList);
//        System.out.println("*******ships.getUserList()*****"+ships.getUserList());
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
        Ships ships = shipsService.findById(582587);
        assertNotNull(ships);
    }

    @Test
    public void findByName() {
//        Ships ships = shipsService.findByName("ZHEPUYU19236");
        Ships ships = shipsService.findByName("falonieShip");
        assertNotNull(ships);
    }

    @Test
    public void findByIdOrName() {
//        Ships ships = shipsService.findByIdOrName(0, "ZHEPUYU19236");
//        Ships ships = shipsService.findByIdOrName(467918, "XXXXXXXXXXXXXXXXXXXXX");
//        Ships ships = shipsService.findByIdOrName(0, "FalonieShip");
        Ships ships = shipsService.findByIdOrName(0, "浙三渔04502");
        assertNotNull(ships);
    }

    @Test
    public void findByProductId() {
        Ships ships = shipsService.findByProductId("AC1111");
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
//    @Transactional
    public void delete() {
        Ships ships = shipsService.findById(1774096);
        shipsService.delete(ships);
//        Ships result = shipsService.findByIdOrName(0, "浙三渔04502");
//        assertNull(result);
//        Ships ships = shipsService.findByIdOrName(0, "FalonieShip");
//        shipsService.delete(ships);
//        Ships result = shipsService.findByIdOrName(0, "FalonieShip");
//        assertNull(result);
    }

    @Test
    public void findByNationLikeOrProvinceLikeOrCityLikeAndUserId() {
        PageRequest request = PageRequest.of(499, 10);
        Page<Ships> shipsPage2 = shipsService.findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId("中国",
                "浙", "舟", "普", 122, request);
        assertNotEquals(0, shipsPage2.getTotalElements());
    }

    @Test
    public void findBindedShipsByEquipmentId() {
        PageRequest request = PageRequest.of(499, 10);
//        Page<Ships> shipsPage2 = shipsService.findBindedShipsByEquipmentId()
    }
}