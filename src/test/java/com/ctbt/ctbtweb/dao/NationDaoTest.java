package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Nation;
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
public class NationDaoTest {
    @Resource
    private NationDao nationDao;

    @Test
    public void getAll() {
        List<Nation> nationList = nationDao.findAll();
        assertNotEquals(0, nationList.size());
        System.out.println("***********" + nationList + "***********");
    }

    @Test
    @Transactional
    public void getNationByName() {
        Nation nation = nationDao.getNationByName("中国");
        assertNotNull(nation);
        System.out.println("***********" + nation + "***********");
    }

    @Test
    public void getNationByNationId() {
        Nation nation = nationDao.getNationByNationId(86);
        assertNotNull(nation);
        System.out.println("***********" + nation + "***********");
    }
}