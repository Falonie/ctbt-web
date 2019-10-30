package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRecordDao extends JpaRepository<AlarmRecord, Integer> {
    AlarmRecord findByAlarmRecordId(int alarmRecordId);
}
