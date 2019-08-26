package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmAreaServiceImplTest {
    @Resource
    private AlarmAreaService alarmAreaService;

    @Test
    @Transactional
    public void save() {
        AlarmArea alarmArea = new AlarmArea();
    }

    @Test
    public void findByAreaIdOrAreaName() {
        AlarmArea alarmArea = alarmAreaService.findByAreaIdOrAreaName(833, "");
//        AlarmArea alarmArea = alarmAreaService.findByAreaIdOrAreaName(40321124, "钓鱼岛敏感海域");
        assertNotNull(alarmArea);
    }

    @Test
    public void findSensitiveAreas() {
        PageRequest request = PageRequest.of(0, 10);
        Page<AlarmArea> sensitiveAreaPage = alarmAreaService.findSensitiveAreas(request);
        assertNotEquals(0, sensitiveAreaPage.getTotalElements());
    }

    @Test
    public void findSensitiveAreasByUserId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<AlarmArea> sensitiveAreaPage = alarmAreaService.findSensitiveAreasByUserId(632, request);
        assertNotEquals(0, sensitiveAreaPage.getTotalElements());
    }
}