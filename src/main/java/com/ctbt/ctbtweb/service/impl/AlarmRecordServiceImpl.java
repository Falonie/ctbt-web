package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmRecordDao;
import com.ctbt.ctbtweb.dao.AlarmToUserDao;
import com.ctbt.ctbtweb.entity.AlarmRecord;
import com.ctbt.ctbtweb.entity.AlarmToUser;
import com.ctbt.ctbtweb.service.AlarmRecordService;
import com.ctbt.ctbtweb.service.AlarmToUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("alarmRecordService")
public class AlarmRecordServiceImpl implements AlarmRecordService {
    @Resource
    private AlarmRecordDao alarmRecordDao;

    @Override
    public AlarmRecord save(AlarmRecord alarmRecord) {
        return alarmRecordDao.save(alarmRecord);
    }

    @Override
    public AlarmRecord findById(int alarmRecordId) {
        return alarmRecordDao.findByAlarmRecordId(alarmRecordId);
    }
}
