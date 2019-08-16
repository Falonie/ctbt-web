package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Ships;
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
public class ShipsDaoTest {
    @Resource
    private ShipsDao shipsDao;

    @Test
    public void findByNationLikeOrProvinceLikeOrCityLikeAndUserId() {
        PageRequest request = PageRequest.of(1165, 10);
        Page<Ships> shipsPage = shipsDao.findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId("中国",
                "浙%", "舟%","", 122, request);
        assertNotEquals(0,shipsPage.getTotalElements());
    }
}