package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmRecord;

public interface AlarmRecordService {
    AlarmRecord save(AlarmRecord alarmRecord);

    AlarmRecord findById(int alarmRecordId);
}
