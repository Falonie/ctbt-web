package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTest {
    @Resource
    private CityDao cityDao;

    @Test
    public void findByName() {
        City city = cityDao.findByName("玉溪市");
        assertNotNull(city);
    }

    @Test
    public void findByCityId() {
        City city = cityDao.findByCityId(520600);
        assertNotNull(city);
    }

    @Test
    public void findByProvinceId() {
        List<City> cities = cityDao.findByProvinceId(520000);
        assertNotEquals(0, cities.size());
    }
}