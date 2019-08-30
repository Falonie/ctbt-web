package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.LogDao;
import com.ctbt.ctbtweb.entity.Log;
import com.ctbt.ctbtweb.service.LogService;
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
    public Log save(Log log) {
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
