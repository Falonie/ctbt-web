package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.City;
import com.ctbt.ctbtweb.entity.Province;
import com.ctbt.ctbtweb.service.CityService;
import com.ctbt.ctbtweb.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceImplTest {
    @Resource
    private CityService cityService;
    @Resource
    private ProvinceService provinceService;

    @Test
//    @Transactional
    public void save() {
        City city = new City();
//        city.setId(19999);
        Province province = provinceService.findProvinceByProvinceId(520000);
//        System.out.println(province);
        city.setProvince(province);
        city.setName("testCity2");
        city.setId(2122);
        City result = cityService.save(city);
        System.out.println("***********" + result + "*************");
        assertNotNull(result);
    }

    @Test
    public void getAll() {
        List<City> cityList = cityService.getAll();
        assertNotEquals(0, cityList.size());
    }

    @Test
    public void getCityByCityName() {
        City city = cityService.getCityByCityName("嘉峪关市");
        assertNotNull(city);
    }

    @Test
    public void getAllByProvinceName() {
    }

    @Test
    public void getCitiesByProvinceId() {
        List<City> cityList = cityService.getCitiesByProvinceId(530000);
        assertNotEquals(0, cityList.size());
    }

    @Test
    public void getCityByCityId() {
        City city = cityService.getCityByCityId(530600);
        assertNotNull(city);
    }

    @Test
    @Transactional
    public void deleteCityByCityName() {
        cityService.deleteCityByCityName("西安市");
        City result = cityService.getCityByCityName("西安市");
        assertNull(result);
    }

    @Test
//    @Transactional
    public void delete() {
        City city = cityService.getCityByCityId(845);
        cityService.delete(city);
        assertNull(cityService.getCityByCityId(845));
    }
}