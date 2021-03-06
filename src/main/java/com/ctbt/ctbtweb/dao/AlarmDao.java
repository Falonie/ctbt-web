package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Alarm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmDao extends JpaRepository<Alarm, Integer> {
    Alarm findByShipIdAndIsAllowAlarm(int shipId, String isAllowAlarm);

    Alarm findByShipIdAndAreaIdAndIsAllowAlarm(int shipId, int areaId, String isAllowAlarm);

    Alarm findByIdOrShipIdOrIsAllowAlarm(int id, int shipId, String isAllowAlarm);

    Alarm findByShipIdOrIsAllowAlarm(int shipId, String isAllowAlarm);

    Page<Alarm> findAllByIsAllowAlarm(String isAllowAlarm, Pageable pageable);

    Page<Alarm> findAllByAreaIdAndIsAllowAlarm(int areaId, String isAllowAlarm, Pageable pageable);

    Page<Alarm> findAll(Pageable pageable);
}
