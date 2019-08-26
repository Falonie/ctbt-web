package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmAreaDao;
import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.service.AlarmAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("alarmAreaService")
public class AlarmAreaServiceImpl implements AlarmAreaService {
    @Resource
    private AlarmAreaDao alarmAreaDao;

    @Override
    public AlarmArea save(AlarmArea alarmArea) {
        return alarmAreaDao.save(alarmArea);
    }

    @Override
    public AlarmArea findByAreaId(int areaId) {
        return alarmAreaDao.findById(areaId).orElse(null);
    }

    @Override
    public AlarmArea findByAreaIdOrAreaName(int areaId, String areaName) {
        return alarmAreaDao.findByAreaIdOrAreaName(areaId, areaName);
    }

    @Override
    public Page<AlarmArea> findSensitiveAreas(Pageable pageable) {
        return alarmAreaDao.findAll(pageable);
    }

    @Override
    public Page<AlarmArea> findSensitiveAreasByUserId(int userId, Pageable pageable) {
        return alarmAreaDao.findByUserId(userId, pageable);
    }
}
