package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmTypeDao;
import com.ctbt.ctbtweb.entity.AlarmType;
import com.ctbt.ctbtweb.service.AlarmTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("alarmTypeService")
public class AlarmTypeServiceImpl implements AlarmTypeService {
    @Resource
    private AlarmTypeDao alarmTypeDao;
    @Override
    public List<AlarmType> findAll() {
        return alarmTypeDao.findAll();
    }
}
