package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlarmAreaService {
    AlarmArea save(AlarmArea alarmArea);

    AlarmArea findByAreaId(int areaId);

    AlarmArea findByAreaIdOrAreaName(int areaId, String areaName);

    Page<AlarmArea> findSensitiveAreas(Pageable pageable);

    Page<AlarmArea> findSensitiveAreasByUserId(int userId, Pageable pageable);
}
