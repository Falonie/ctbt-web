package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmToUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlarmToUserService {
    AlarmToUser save(AlarmToUser alarmToUser);

    AlarmToUser findById(int id);

    AlarmToUser findByAlarmRecordId(int alarmRecordId);

    List<AlarmToUser> findAllByAlarmRecordId(int alarmRecordId);

    void delete(AlarmToUser alarmToUser);

    Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable);
}
