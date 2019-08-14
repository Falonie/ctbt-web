package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Village;
import com.ctbt.ctbtweb.service.VillageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VillageServiceImplTest {
    @Resource
    private VillageService villageService;

//    @Test
////    @Transactional
//    public void save() {
//        Village village = new Village();
//        village.setName("testVillage");
////        village.setTownId(401);
//        Village result = villageService.save(village);
//        assertNotNull(result);
//    }

    @Test
//    @Transactional
    public void delete() {
        Village village = villageService.findById(752);
        villageService.delete(village);
        assertNull(villageService.findById(752));
    }

    @Test
    @Transactional
    public void update() {
    }

    @Test
    public void findById() {
        Village village = villageService.findById(752);
        assertNotNull(village);
    }

    @Test
    public void findAll() {
    }
}