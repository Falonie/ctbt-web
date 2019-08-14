package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.SensitiveArea;
import com.ctbt.ctbtweb.service.SensitiveAreaService;
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
public class SensitiveAreaServiceImplTest {
    @Resource
    private SensitiveAreaService sensitiveAreaService;

    @Test
    public void findSensitiveAreas() {
        PageRequest request = PageRequest.of(0, 10);
        Page<SensitiveArea> sensitiveAreaPage = sensitiveAreaService.findSensitiveAreas(request);
        assertNotEquals(0, sensitiveAreaPage.getTotalElements());
    }

    @Test
    public void findSensitiveAreasByUserId() {
        PageRequest request = PageRequest.of(0, 10);
        Page<SensitiveArea> sensitiveAreaPage = sensitiveAreaService.findSensitiveAreasByUserId(632,request);
        assertNotEquals(0, sensitiveAreaPage.getTotalElements());
    }
}