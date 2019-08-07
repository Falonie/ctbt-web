package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.domain.Nation;
import com.ctbt.ctbtweb.domain.Province;
import com.ctbt.ctbtweb.service.NationService;
import com.ctbt.ctbtweb.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceServiceImplTest {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private NationService nationService;


    @Test
//    @Transactional
    public void save() {
        Province province = new Province();
//        province.setNationId(86);
        Nation nation = nationService.findOne(86);
        province.setNation(nation);
        province.setName("testProvince");
        province.setId(42);
        Province result = provinceService.save(province);
        System.out.println("***********" + province + "***********");
        assertNotNull(result);
    }

    @Test
    public void findAll() {
        List<Province> provinceList = provinceService.findAll();
        assertNotEquals(0, provinceList.size());
    }

    @Test
    public void findAllByNationName() {
        List<Province> provinceList = provinceService.findAllByNationName("中国");
        assertNotEquals(0, provinceList.size());
    }

    @Test
    public void findProvinceByProvinceName() {
        Province province = provinceService.findProvinceByProvinceName("上海市");
        assertNotNull(province);
    }

    @Test
    public void findProvinceByProvinceId() {
        Province province = provinceService.findProvinceByProvinceId(new Integer("310000"));
        assertNotNull(province);
    }

    @Test
    public void findAll1() {
        PageRequest request = PageRequest.of(0, 10);
        Page<Province> provincePage = provinceService.findAll(request);
        System.out.println("**********" + provincePage.getContent() + "**********");
        assertNotEquals(0, provincePage.getTotalElements());
    }

    @Test
//    @Transactional
    public void delete() {
        Province province = provinceService.findProvinceByProvinceId(816);
        provinceService.delete(province);
        assertNull(provinceService.findProvinceByProvinceId(816));
    }
}