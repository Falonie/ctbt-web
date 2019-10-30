package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.AlarmToUserDao;
import com.ctbt.ctbtweb.entity.AlarmToUser;
import com.ctbt.ctbtweb.service.AlarmToUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("alarmToUserService")
public class AlarmToUserServiceImpl implements AlarmToUserService {
    @Resource
    private AlarmToUserDao alarmToUserDao;

    @Override
    public Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable) {
        Page<AlarmToUser> alarmToUserPage = alarmToUserDao.findAllByUserId(userId, pageable);
        return new PageImpl<AlarmToUser>(alarmToUserPage.getContent(), pageable, alarmToUserPage.getTotalElements());
    }
}
