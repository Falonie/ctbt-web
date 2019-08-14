package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Town;
import com.ctbt.ctbtweb.service.TownService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TownServiceImplTest {
    @Resource
    private TownService townService;

//    @Test
//    @Transactional
//    public void save() {
//        Town town = new Town();
//        town.setName("testName");
////        town.setCountyId(330902);
//        Town result = townService.save(town);
//        System.out.println("************" + result + "************");
//        assertNotNull(result);
//    }

    @Test
    public void findTownByTownName() {
        Town town = townService.findTownByTownName("环南街道");
        assertNotNull(town);
    }

    @Test
    public void findTownByTownId() {
        Town town = townService.findTownByTownId(461);
        assertNotNull(town);
    }

    @Test
    public void getTownListByCountyId() {
        List<Town> townList = townService.getTownListByCountyId(330902);
        assertNotEquals(0, townList.size());
    }
}