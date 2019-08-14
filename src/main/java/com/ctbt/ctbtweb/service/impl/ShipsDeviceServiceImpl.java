package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsDeviceDao;
import com.ctbt.ctbtweb.entity.ShipsDevice;
import com.ctbt.ctbtweb.service.ShipsDeviceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipsDeviceService")
public class ShipsDeviceServiceImpl implements ShipsDeviceService {
    @Resource
    private ShipsDeviceDao shipsDeviceDao;

    @Override
    public Page<ShipsDevice> findByShipsDeviceId(String deviceId, Pageable pageable) {
        Page<ShipsDevice> shipsDevicePage = shipsDeviceDao.findAllByDeviceId(deviceId, pageable);
        return new PageImpl<ShipsDevice>(shipsDevicePage.getContent(), pageable, shipsDevicePage.getTotalElements());
    }

    @Override
    public Page<ShipsDevice> findByShipsId(int shipId, Pageable pageable) {
        Page<ShipsDevice> shipsDevicePage = shipsDeviceDao.findByShipsId(shipId, pageable);
        return new PageImpl<ShipsDevice>(shipsDevicePage.getContent(), pageable, shipsDevicePage.getTotalElements());
    }
}
