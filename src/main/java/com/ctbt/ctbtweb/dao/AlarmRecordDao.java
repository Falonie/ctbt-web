package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmRecord;
import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRecordDao extends JpaRepository<AlarmRecord, Integer> {
    AlarmRecord findByAlarmRecordId(int alarmRecordId);

    List<AlarmRecord> findAllByShips(Ships ships);
}
