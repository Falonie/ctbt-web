package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipsToAlarmArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipsToAlarmAreaDao extends JpaRepository<ShipsToAlarmArea, Integer> {
    ShipsToAlarmArea findByShipIdOrAreaId(int shipId, int areaId);

    Page<ShipsToAlarmArea> findAll(Pageable pageable);
}
