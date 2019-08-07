package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsDao;
import com.ctbt.ctbtweb.domain.Ships;
import com.ctbt.ctbtweb.service.ShipsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipsService")
public class ShipsServiceImpl implements ShipsService {
    @Resource
    private ShipsDao shipsDao;

    @Override
    public Ships save(Ships ships) {
        return shipsDao.save(ships);
    }

    @Override
    public Ships update(Ships ships) {
        return shipsDao.save(ships);
    }

    @Override
    public Ships findById(int id) {
        return shipsDao.findById(id);
    }

    @Override
    public Page<Ships> findAll(Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findAll(pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByDeviceId(int equipmentId, int mmsi, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByEquipmentidOrMmsi(String.valueOf(equipmentId), String.valueOf(mmsi), pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public void delete(Ships ships) {
        shipsDao.delete(ships);
    }
}
