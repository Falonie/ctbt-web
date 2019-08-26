package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Alarm;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import com.ctbt.ctbtweb.service.AlarmService;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmServiceImplTest {
    @Resource
    private AlarmService alarmService;
    @Resource
    private ShipsService shipsService;
    @Resource
    private AlarmAreaService alarmAreaService;
    private static final int SHIP_ID = 467410;
    private static final int SHIP_ID2 = 467417;
    private static final int SHIP_ID3 = 467426;
    private static final int SHIP_ID4 = 467459;
    private static final int SHIP_ID5 = 467424;
    private static final int SENSITIVEAREA_ID = 401;
    private static final int SENSITIVEAREA_ID2 = 409;

    @Test
//    @Transactional
    public void save() {
        Alarm alarm = new Alarm();
        Ships ships = shipsService.findById(SHIP_ID4);
        alarm.setShipId(ships.getId());
        alarm.setShipName(ships.getName());
        alarm.setProductId(ships.getProductId());
        alarm.setEquipmentId(ships.getEquipmentid());
        alarm.setIsAllowAlarm("0");
        alarm.setContent("Falonie");
        alarm.setCreateTime(new Date());
//        AlarmArea sensitiveArea = alarmAreaService.findByAreaIdOrAreaName(SENSITIVEAREA_ID,"");
        alarm.setAreaId(SENSITIVEAREA_ID);
        Alarm result = alarmService.save(alarm);
        assertNotNull(result);
    }

    @Test
    public void findByShipIdAndIsAllowAlarm() {
        Alarm alarm = alarmService.findByShipIdAndIsAllowAlarm(467417, "0");
        assertNull(alarm);
//        assertNotNull(alarm);
    }

    @Test
    public void findByIdOrShipIdOrIsAllowAlarm() {
        Alarm alarm = alarmService.findByIdOrShipIdOrIsAllowAlarm(0, 467417, "");
        assertNotNull(alarm);
    }

    @Test
    public void findByShipIdOrIsAllowAlarm() {
        Alarm alarm = alarmService.findByShipIdOrIsAllowAlarm(467417, "1");
        assertNotNull(alarm);
    }

    @Test
    public void findAllByIsAllowAlarm() {
        PageRequest request = PageRequest.of(0, 10);
        Page<Alarm> allowAlarmPage = alarmService.findAllByIsAllowAlarm("1", request);
        assertNotEquals(0, allowAlarmPage.getTotalElements());
    }

    @Test
    public void findAllByAreaIdAndIsAllowAlarm() {
        PageRequest request = PageRequest.of(0, 10);
        Page<Alarm> allowAlarmPage = alarmService.findAllByAreaIdAndIsAllowAlarm(401,"1", request);
        assertNotEquals(0, allowAlarmPage.getTotalElements());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<Alarm> allowAlarmPage = alarmService.findAll(request);
        assertNotEquals(0, allowAlarmPage.getTotalElements());
    }

    @Test
    @Transactional
    public void delete() {
        Alarm alarm = alarmService.findByIdOrShipIdOrIsAllowAlarm(0, 467417, "");
        alarmService.delete(alarm);
        assertNull(alarmService.findByIdOrShipIdOrIsAllowAlarm(0, 467417, ""));
    }
}