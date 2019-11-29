package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.ShipTeam;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.ShipTeamService;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ShipTeamServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private ShipTeamService shipTeamService;
    @Resource
    private ShipsService shipsService;

    @Test
    @Transactional
    public void save() {
        ShipTeam result = shipTeamService.save(1774624, "falonieShipTeam", 11);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void findById() {
        ShipTeam shipTeam = shipTeamService.findById(15);
        assertNotNull(shipTeam);
    }

    @Test
    public void findAll() {
        List<ShipTeam> shipTeamList = shipTeamService.findAll();
        assertNotEquals(0, shipTeamList.size());
    }

    @Test
    public void testFindAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipTeam> shipTeamPage = shipTeamService.findAll(request);
        assertNotEquals(0, shipTeamPage.getTotalElements());

    }

    @Test
    @Transactional
    public void delete() {
        ShipTeam shipTeam = shipTeamService.findById(37);
        shipTeamService.delete(shipTeam);
        assertNull(shipTeamService.findById(37));
    }
}