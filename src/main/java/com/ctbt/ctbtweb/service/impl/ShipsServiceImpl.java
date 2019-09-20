package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsDao;
import com.ctbt.ctbtweb.entity.Ships;
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
    public Ships findByName(String shipName) {
        return shipsDao.findByName(shipName);
    }

    @Override
    public Ships findByIdOrName(int id, String name) {
        return shipsDao.findByIdOrName(id, name);
    }

    @Override
    public Ships findByEquipmentId(String equipmentId) {
        return shipsDao.findByEquipmentId(equipmentId);
    }

    @Override
    public Page<Ships> findAll(Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findAll(pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByDeviceId(int equipmentId, int mmsi, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByEquipmentIdOrMmsi(String.valueOf(equipmentId), String.valueOf(mmsi), pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
            String nation, String province, String city, String county, int userId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(nation, province,
                city, county, userId, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByIsUnpowerAndUserId(int userId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByIsUnpowerAndUserId( userId,"1", pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public void delete(Ships ships) {
        shipsDao.delete(ships);
    }

    @Override
    public void addShipToSensitiveArea(Ships ships) {

    }
}
