package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmToUserDao;
import com.ctbt.ctbtweb.entity.AlarmToUser;
import com.ctbt.ctbtweb.service.AlarmToUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("alarmToUserService")
public class AlarmToUserServiceImpl implements AlarmToUserService {
    @Resource
    private AlarmToUserDao alarmToUserDao;

    @Override
    public AlarmToUser save(AlarmToUser alarmToUser) {
        return alarmToUserDao.save(alarmToUser);
    }

    @Override
    public AlarmToUser findById(int id) {
        Optional<AlarmToUser> alarmToUser = alarmToUserDao.findById(id);
        return alarmToUser.orElse(null);
    }

    @Override
    public AlarmToUser findByAlarmRecordId(int alarmRecordId) {
        return alarmToUserDao.findByAlarmRecordId(alarmRecordId);
    }

    @Override
    public List<AlarmToUser> findAllByAlarmRecordId(int alarmRecordId) {
        return alarmToUserDao.findAllByAlarmRecordId(alarmRecordId);
    }

    @Override
    public void delete(AlarmToUser alarmToUser) {
        alarmToUserDao.delete(alarmToUser);
    }

    @Override
    public Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable) {
        Page<AlarmToUser> alarmToUserPage = alarmToUserDao.findAllByUserId(userId, pageable);
        return new PageImpl<AlarmToUser>(alarmToUserPage.getContent(), pageable, alarmToUserPage.getTotalElements());
    }
}
