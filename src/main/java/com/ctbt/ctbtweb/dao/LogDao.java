package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface LogDao extends JpaRepository<Log, Integer> {
    Page<Log> findByType(String type, Pageable pageable);

//    @Query(value = "select * from LOG_TABLE where TYPE ='用户日志' and CLIENTTYPE='Web' and " +
//            "(IPADDRESS ='' or IPADDRESS is null) and (MACADDRESS ='' or MACADDRESS is null ) and" +
//            " DATETIME between to_date('2019-08-29','yyyy-mm-dd') and to_date('2019-08-30','yyyy-mm-dd')",nativeQuery = true)
    @Query(value = "select * from LOG_TABLE where TYPE =:type and CLIENTTYPE=:clientType and " +
            "(IPADDRESS =:ipAddress or IPADDRESS is null) and " +
            "(MACADDRESS=:macAddress or MACADDRESS is null) and DATETIME between to_date(:startDate,'yyyy-mm-dd') and " +
            "to_date(:endDate,'yyyy-mm-dd')", nativeQuery = true)
//    @Query(value = "select * from LOG_TABLE where TYPE =:type and CLIENTTYPE=:clientType and IPADDRESS =:ipAddress and " +
//            "MACADDRESS=:macAddress and DATETIME between to_date(:startDate,'yyyy-mm-dd') and " +
//            "to_date(:endDate,'yyyy-mm-dd')", nativeQuery = true)
//    Page<Log> findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
//            String type, String clientType, String ipAddress, String macAddress, Date startDate, Date endDate, Pageable pageable
//    );
    Page<Log> findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
            String type, String clientType, String ipAddress, String macAddress, String startDate, String endDate, Pageable pageable
    );
}
