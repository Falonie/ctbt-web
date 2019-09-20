package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.LogDao;
import com.ctbt.ctbtweb.entity.Log;
import com.ctbt.ctbtweb.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    @Override
    public Log save(Log log,JoinPoint joinPoint) {
        log.setDate(new Date());
        log.setClassName(joinPoint.getTarget().getClass().getName());
        return logDao.save(log);
    }

    @Override
    public Log addClientLog(Log log) {
        log.setDate(new Date());
        log.setType("ClientLog");
        return logDao.save(log);
    }

    @Override
    public Log addUserLog(Log log) {
        log.setDate(new Date());
        log.setType("UserLog");
        return logDao.save(log);
    }

    @Override
    public Page<Log> findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
//            String type, String clientType, String ipAddress, String macAddress, Date start, Date end, Pageable pageable
            String type, String clientType, String ipAddress, String macAddress,String start, String end, Pageable pageable
    ) {
        Page<Log> logPage = logDao.findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
                type, clientType, ipAddress, macAddress, start, end, pageable);
        return new PageImpl<Log>(logPage.getContent(), pageable, logPage.getTotalElements());
    }
}
