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
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

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
    public void findByShipId() {
        List<ShipsToUsers> shipsToUsersList = shipsToUsersService.findByShipId(1773994);
        assertNotEquals(0, shipsToUsersList.size());
    }

    @Test
    public void findByUserIdAndShipId() {
    }

    @Test
    @Transactional
    public void save() {
        ShipsToUsers shipsToUsers = new ShipsToUsers();
        shipsToUsers.setShipId(1773995);
        shipsToUsers.setUserId(856);
        shipsToUsers.setUpdateEquipmentIdDate(new Date());
        ShipsToUsers result = shipsToUsersService.save(shipsToUsers);
        assertNotNull(result);
    }

    @Test
    @Transactional
    public void delete() {
        ShipsToUsers shipsToUsers = shipsToUsersService.findByUserIdAndShipId(856, 1774105);
        shipsToUsersService.delete(shipsToUsers);
        assertNull(shipsToUsersService.findByUserIdAndShipId(856, 1774105));
    }
}