package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Village;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VillageDaoTest {
    @Resource
    private VillageDao villageDao;

    @Test
    public void findById() {
//        Village village=villageDao.findById(752);
//        assertNotNull(village);
    }
}