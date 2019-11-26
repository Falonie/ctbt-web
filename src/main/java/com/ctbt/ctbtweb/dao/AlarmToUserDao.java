package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmToUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmToUserDao extends JpaRepository<AlarmToUser, Integer> {
    AlarmToUser findByAlarmRecordId(int alarmRecordId);

    List<AlarmToUser> findAllByAlarmRecordId(int alarmRecordId);

    Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable);
}
