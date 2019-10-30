package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.CtbtWebApplicationTests;
import com.ctbt.ctbtweb.entity.AlarmType;
import com.ctbt.ctbtweb.service.AlarmTypeService;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class AlarmTypeServiceImplTest extends CtbtWebApplicationTests {
    @Resource
    private AlarmTypeService alarmTypeService;

    @Test
    public void findAll() {
        List<AlarmType> alarmTypeList = alarmTypeService.findAll();
        assertNotEquals(0, alarmTypeList.size());
    }
}