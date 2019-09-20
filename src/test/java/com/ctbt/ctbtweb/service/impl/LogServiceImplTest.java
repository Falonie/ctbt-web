package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.entity.Log;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.service.LogService;
import com.ctbt.ctbtweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogServiceImplTest {
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;

    @Test
//    @Transactional
    public void save() {
        Log log = new Log();
        log.setClientType("WEB");
        log.setType("查看");
        log.setDate(new Date());
        User user = userService.findByIdOrUsername(122, "");
        log.setUser(user);
//        Log result = logService.save(log);
//        assertNotNull(result);
    }

    @Test
    public void findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd() {
        PageRequest request = PageRequest.of(0, 10);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//        String startDate = simpleDateFormat.format("2019-08-29");
        Page<Log> logPage = logService.findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
                "用户日志", "Web", "", "", "2019-08-29",
                "2019-08-30", request);
        System.out.println("***************" + logPage.getContent());
        assertNotEquals(0, logPage.getTotalElements());
    }
}