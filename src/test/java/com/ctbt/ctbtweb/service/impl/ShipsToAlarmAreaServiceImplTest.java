package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.ShipsToAlarmArea;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.service.ShipsToAlarmAreaService;
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
public class ShipsToAlarmAreaServiceImplTest {
    @Resource
    private ShipsToAlarmAreaService shipsToAlarmAreaService;
    @Resource
    private ShipsService shipsService;

    private final int shipId = 466889;

    private final int sensitiveAreaId = 856;

    @Test
//    @Transactional
    public void save() {
        ShipsToAlarmArea shipsToAlarmArea = new ShipsToAlarmArea();
        shipsToAlarmArea.setShipId(shipId);
        shipsToAlarmArea.setAreaId(sensitiveAreaId);
        ShipsToAlarmArea result = shipsToAlarmAreaService.save(shipsToAlarmArea);
        assertNotNull(result);
    }

    @Test
    public void findById() {
        ShipsToAlarmArea shipsToAlarmArea = shipsToAlarmAreaService.findById(897);
        assertNotNull(shipsToAlarmArea);
    }

    @Test
    public void findByShipIdOrAreaId() {
//        ShipsToAlarmArea shipsToAlarmArea = shipsToAlarmAreaService.findByShipIdOrAreaId(0, 856);
        ShipsToAlarmArea shipsToAlarmArea = shipsToAlarmAreaService.findByShipIdOrAreaId(466889, 111111);
        assertNotNull(shipsToAlarmArea);
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ShipsToAlarmArea> shipsToAlarmAreaPage = shipsToAlarmAreaService.findAll(request);
        assertNotEquals(0, shipsToAlarmAreaPage.getTotalElements());
    }

    @Test
    public void delete() {
        ShipsToAlarmArea shipsToAlarmArea = shipsToAlarmAreaService.findByShipIdOrAreaId(466889, 111111);
        shipsToAlarmAreaService.delete(shipsToAlarmArea);
        assertNull(shipsToAlarmAreaService.findByShipIdOrAreaId(466889, 111111));
    }
}