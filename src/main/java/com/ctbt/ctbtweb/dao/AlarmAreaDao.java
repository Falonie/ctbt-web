package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmAreaDao extends JpaRepository<AlarmArea, Integer> {
    AlarmArea findByAreaIdOrAreaName(int areaId, String areaName);

    Page<AlarmArea> findByUserId(int userId, Pageable pageable);
}
