package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.County;
import com.ctbt.ctbtweb.service.CountyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountyServiceImplTest {
    @Resource
    private CountyService countyService;

//    @Test
//    @Transactional
//    public void save() {
//        County county = new County();
//        county.setCityId(210600);
//        county.setName("testCity");
//        County result = countyService.save(county);
//        System.out.println("***********" + result + "***********");
//        assertNotNull(result);
//    }

    @Test
    public void findCountyByCountyName() {
        County county = countyService.findCountyByCountyName("南昌县");
        assertNotNull(county);
    }

    @Test
    public void findCountiesByCityId() {
        List<County> countyList = countyService.findCountiesByCityId(350800);
        assertNotEquals(0, countyList);
    }

    @Test
    public void findCountyByCountyId() {
        County county = countyService.findCountyByCountyId(350803);
        assertNotNull(county);
    }
}