package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.SensitiveAreaDao;
import com.ctbt.ctbtweb.entity.SensitiveArea;
import com.ctbt.ctbtweb.service.SensitiveAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sensitiveAreaService")
public class SensitiveAreaServiceImpl implements SensitiveAreaService {
    @Resource
    private SensitiveAreaDao sensitiveAreaDao;

    @Override
    public Page<SensitiveArea> findSensitiveAreas(Pageable pageable) {
        return sensitiveAreaDao.findAll(pageable);
    }

    @Override
    public Page<SensitiveArea> findSensitiveAreasByUserId(int userId, Pageable pageable) {
        return sensitiveAreaDao.findByUserId(userId, pageable);
    }
}
