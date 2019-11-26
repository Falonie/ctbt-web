package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.AlarmRecord;
import com.ctbt.ctbtweb.entity.AlarmToUser;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.AlarmRecordService;
import com.ctbt.ctbtweb.service.AlarmToUserService;
import com.ctbt.ctbtweb.service.ShipsService;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

@Component
public class AlarmToUserServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private AlarmToUserService alarmToUserService;
    @Resource
    private ShipsService shipsService;
    @Resource
    private AlarmRecordService alarmRecordService;

    @Test
//    @Transactional
    public void save() {
        AlarmToUser alarmToUser = new AlarmToUser();
        alarmToUser.setAlarmRecordId(286788);
        alarmToUser.setUserId(122);
        alarmToUser.setUserName("admin");
        alarmToUser.setProcessType("1");
        alarmToUser.setUserType(1);
        alarmToUser.setCreateTime(new Date());
        AlarmToUser result = alarmToUserService.save(alarmToUser);
        assertNotNull(result);
    }

    @Test
//    @Transactional
    public void saveRecord() {
        AlarmRecord alarmRecord = new AlarmRecord();
        Ships ships = shipsService.findById(1774659);
        alarmRecord.setShips(ships);
        alarmRecord.setDeviceId(ships.getEquipmentId());
        alarmRecord.setEquipmentId(ships.getEquipmentId());
        alarmRecord.setTime(new Date());
        AlarmRecord alarmRecordResult = alarmRecordService.save(alarmRecord);
//        System.out.println(result);
//        assertNotNull(result);

        AlarmToUser alarmToUser = new AlarmToUser();
        alarmToUser.setAlarmRecordId(alarmRecordResult.getAlarmRecordId());
        alarmToUser.setUserId(122);
        alarmToUser.setUserName("admin");
        alarmToUser.setProcessType("1");
        alarmToUser.setUserType(1);
        alarmToUser.setCreateTime(new Date());
        AlarmToUser result = alarmToUserService.save(alarmToUser);
        assertNotNull(result);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByAlarmRecordId() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAllByUserId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<AlarmToUser> alarmToUserPage = alarmToUserService.findAllByUserId(122, request);
        System.out.println("alarmToUserPage" + alarmToUserPage.getTotalElements());
        assertNotEquals(0, alarmToUserPage.getTotalElements());
    }
}