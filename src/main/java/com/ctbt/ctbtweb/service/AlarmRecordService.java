package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmRecord;
import com.ctbt.ctbtweb.entity.Ships;

import java.util.List;

public interface AlarmRecordService {
    AlarmRecord save(AlarmRecord alarmRecord);

    AlarmRecord findById(int alarmRecordId);

    List<AlarmRecord> findByShipId(Ships ship);

    void delete(AlarmRecord alarmRecord);

    void deleteAll();
}
