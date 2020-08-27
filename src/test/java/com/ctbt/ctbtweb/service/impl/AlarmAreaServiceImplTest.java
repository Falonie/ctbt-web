package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
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
public class AlarmAreaServiceImplTest {
    @Resource
    private AlarmAreaService alarmAreaService;

    @Test
//    @Transactional
    public void save() {
        AlarmArea alarmArea = new AlarmArea();
//        AlarmArea alarmArea2 = alarmAreaService.findByAreaIdOrAreaName(1050, "");
//        alarmArea2.setAreaAlarmType("2");
        alarmArea.setAreaId(1052);
        alarmArea.setAreaName("演习海域");
        alarmArea.setUserId(1487);
        alarmArea.setAreaFunction("警戒区");
        alarmArea.setPeopleName("东山县");
        alarmArea.setAreaTime(new Date());
        alarmArea.setAreaType("1");
        alarmArea.setAreaFunc("9");
        alarmArea.setAreaAlarmType("4");
        alarmArea.setValidity("1");
        alarmArea.setGeometry("{\"spatialReference\": {\"wkid\": 102100}, \"rings\": [[[13085606.142749308, 2694621.469779249], [13098593.416675115, 2694621.469779249], [13098593.416675115, 2682485.8006419167], [13085606.142749308, 2682485.8006419167]]]}");
//        alarmArea.setGeometry("{\"spatialReference\": {\"wkid\": 102100}, \"rings\": [[[13506460.609553142, 3555457.632911431], [13513575.64802904, 3554031.284497758], [13518889.600306585, 3551747.535531264], [13518854.938044291, 3549945.869623504], [13513309.634120313, 3551563.221245345], [13506946.006815892, 3552835.770333194], [13506460.611690477, 3553054.5898883427]]]}");
//        alarmArea.setGeometry("{\"spatialReference\": {\"wkid\": 102100}, \"rings\": [[[13506460.609553142, 3555457.632911431], [13513575.64802904, 3554031.284497758], [13518889.600306585, 3551747.535531264], [13518854.938044291, 3549945.869623504], [13513309.634120313, 3551563.221245345], [13506946.006815892, 3552835.770333194], [13506460.611690477, 3553054.5898883427]]]}");
//        alarmArea.setGeometry("{\"spatialReference\": {\"wkid\": 102100}, \"rings\": [[[13506460.609553304, 3555457.6320063532], [13513575.648029204, 3554031.283593042], [13518889.60030675, 3551747.534627128], [13518854.938044455, 3549945.8687198306], [13513309.634120474, 3551563.220341259], [13506946.006816054, 3552835.7694287845], [13506460.611690637, 3553054.588983875]]]}");
        AlarmArea result = alarmAreaService.save(alarmArea);
//        System.out.println(alarmArea);
//        assertNotNull(alarmArea);
        assertNotNull(result);
    }

    @Test
//    @Transactional
    public void save2() {
        AlarmArea alarmArea = new AlarmArea();
        AlarmArea alarmArea2 = alarmAreaService.findByAreaIdOrAreaName(1050, "");
        BeanUtils.copyProperties(alarmArea2, alarmArea);
        alarmArea.setAreaAlarmType("2");

//        alarmArea.setAreaName(alarmArea2.getAreaName());
//        alarmArea.setPeopleName(alarmArea2.getPeopleName());
//        alarmArea.setUserId(alarmArea2.getUserId());
//        alarmArea.setAreaTime(alarmArea2.getAreaTime());
//        alarmArea.setAreaFunction(alarmArea2.getAreaFunction());
//        alarmArea.setGeometry(alarmArea2.getGeometry());
//        alarmArea.setAreaAlarmType("2");
//        alarmArea.setAreaType(alarmArea2.getAreaType());
//        alarmArea.setValidity(alarmArea2.getValidity());
        AlarmArea result = alarmAreaService.save(alarmArea);
        System.out.println(alarmArea);
//        assertNotNull(alarmArea);
        assertNotNull(result);
    }

    @Test
//    @Transactional
    public void findByAreaIdOrAreaName() {
        AlarmArea alarmArea = alarmAreaService.findByAreaIdOrAreaName(1052, "");
        alarmArea.setGeometry(
                "{\"spatialReference\": {\"wkid\": 102100}, \"rings\": [[[13085606.142749308, 2694621.469779249], [13098593.416675115, 2694621.469779249], [13098593.416675115, 2682485.8006419167], [13085606.142749308, 2682485.8006419167], [13085606.142749308, 2694621.469779249]]]}"
            );
        AlarmArea result = alarmAreaService.save(alarmArea);
        System.out.println(result);
        assertNotNull(result);
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