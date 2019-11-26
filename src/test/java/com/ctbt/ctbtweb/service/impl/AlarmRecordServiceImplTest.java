package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.AlarmRecord;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.AlarmRecordService;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@Component
public class AlarmRecordServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private AlarmRecordService alarmRecordService;
    @Resource
    private ShipsService shipsService;

    @Test
//    @Transactional
    public void save() {
        AlarmRecord alarmRecord = new AlarmRecord();
        Ships ships = shipsService.findById(1774657);
        alarmRecord.setShips(ships);
        alarmRecord.setDeviceId(ships.getEquipmentId());
        alarmRecord.setEquipmentId(ships.getEquipmentId());
        alarmRecord.setTime(new Date());
        AlarmRecord result = alarmRecordService.save(alarmRecord);
//        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void findById() {
    }
}