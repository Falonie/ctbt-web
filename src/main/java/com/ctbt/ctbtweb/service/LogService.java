package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Log;
import org.aspectj.lang.JoinPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface LogService {
    Log save(Log log, JoinPoint joinPoint);

    Log addClientLog(Log log);

    Log addUserLog(Log log);

    //    Page<Log> findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
//            String type, String clientType, String ipAddress, String macAddress, Date start, Date end, Pageable pageable
//    );
    Page<Log> findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
            String type, String clientType, String ipAddress, String macAddress, String startDate, String endDate, Pageable pageable
    );

}
