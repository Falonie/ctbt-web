package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.PushData;
import com.ctbt.ctbtweb.service.PushDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushDataServiceImplTest {
    @Resource
    private PushDataService pushDataService;

    @Test
    public void findAll() {
        List<PushData> pushDataList = pushDataService.findAll();
        assertNotEquals(0, pushDataList.size());
    }

    @Test
    public void findById() {
        PushData pushData = pushDataService.findById(401);
        assertNotNull(pushData);
    }

    @Test
    @Transactional
    public void save() {
        PushData pushData = new PushData();
        pushData.setName("testPushData");
        pushData.setIpAddress("122.226.21.229");
        pushData.setPort("7900");
        pushData.setStartDate(new Date());
        PushData result = pushDataService.save(pushData);
        assertNotNull(result);
    }

    @Test
    @Transactional
    public void update() {
        PushData pushData = pushDataService.findById(401);
        pushData.setIpAddress("000.000.000");
        pushData.setPort("0000");
        PushData result = pushDataService.save(pushData);
        assertNotNull(result);
    }

    @Test
    @Transactional
    public void delete() {
        PushData pushData = pushDataService.findById(401);
        pushDataService.delete(pushData);
        assertNull(pushDataService.findById(401));
    }
}