package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.domain.Nation;
import com.ctbt.ctbtweb.service.NationService;
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
public class NationServiceImplTest {
    @Resource
    private NationService nationService;

    @Test
    @Transactional
    public void save() {
        Nation nation = new Nation();
        nation.setName("日本");
        nation.setNationId(87);
        nation.setId(2);
        Nation result = nationService.save(nation);
        assertNotNull(result);
        System.out.println("***********" + nation + "***********");
    }

    @Test
    public void findOne() {
        Nation nation = nationService.findOne(86);
        assertNotNull(nation);
        System.out.println("***********" + nation + "***********");
    }

    @Test
    public void findOneByName() {
        Nation nation = nationService.findOneByName("中国");
        assertNotNull(nation);
        System.out.println("***********" + nation + "***********");
    }

    @Test
    public void findAll() {
        List<Nation> nationList = nationService.findAll();
        assertNotEquals(0, nationList);
        System.out.println("***********" + nationList + "***********");
    }

    @Test
    @Transactional
    public void deleteByNationId() {
        int result = nationService.deleteByNationId(87);
        assertEquals(1, result);
    }
}