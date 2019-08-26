package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmDao;
import com.ctbt.ctbtweb.entity.Alarm;
import com.ctbt.ctbtweb.service.AlarmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
    @Resource
    private AlarmDao alarmDao;

    @Override
    public Alarm save(Alarm alarm) {
        return alarmDao.save(alarm);
    }

    @Override
    public Alarm findByShipIdAndIsAllowAlarm(int shipId, String isAllowAlarm) {
        return alarmDao.findByShipIdAndIsAllowAlarm(shipId, isAllowAlarm);
    }

    @Override
    public Alarm findByShipIdAndAreaIdAndIsAllowAlarm(int shipId, int areaId, String isAllowAlarm) {
        return alarmDao.findByShipIdAndAreaIdAndIsAllowAlarm(shipId, areaId, isAllowAlarm);
    }

    @Override
    public Alarm findByIdOrShipIdOrIsAllowAlarm(int id, int shipId, String isAllowAlarm) {
        return alarmDao.findByIdOrShipIdOrIsAllowAlarm(id, shipId, isAllowAlarm);
    }

    @Override
    public Alarm findByShipIdOrIsAllowAlarm(int shipId, String isAllowAlarm) {
        return alarmDao.findByShipIdOrIsAllowAlarm(shipId, isAllowAlarm);
    }

    @Override
    public Page<Alarm> findAllByIsAllowAlarm(String isAllowAlarm, Pageable pageable) {
        Page<Alarm> allowAlarmPage = alarmDao.findAllByIsAllowAlarm(isAllowAlarm, pageable);
        return new PageImpl<Alarm>(allowAlarmPage.getContent(), pageable, allowAlarmPage.getTotalElements());
    }

    @Override
    public Page<Alarm> findAllByAreaIdAndIsAllowAlarm(int areaId, String isAllowAlarm, Pageable pageable) {
        Page<Alarm> allowAlarmPage = alarmDao.findAllByAreaIdAndIsAllowAlarm(areaId, isAllowAlarm, pageable);
        return new PageImpl<Alarm>(allowAlarmPage.getContent(), pageable, allowAlarmPage.getTotalElements());
    }

    @Override
    public Page<Alarm> findAll(Pageable pageable) {
        Page<Alarm> allowAlarmPage = alarmDao.findAll(pageable);
        return new PageImpl<Alarm>(allowAlarmPage.getContent(), pageable, allowAlarmPage.getTotalElements());
    }

    @Override
    public void delete(Alarm alarm) {
        alarmDao.delete(alarm);
    }
}
