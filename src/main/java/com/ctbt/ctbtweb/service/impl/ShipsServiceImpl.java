package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsDao;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.service.ShipsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Ships> findByIdIn(List<Integer> shipIdList) {
        return shipsDao.findByIdIn(shipIdList);
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
    public Ships findByProductId(String productId) {
        return shipsDao.findByProductId(productId);
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
        Page<Ships> shipsPage = shipsDao.findByIsUnpowerAndUserId(userId, "1", pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByProductIdAndEquipmentIdAndNameAndIdAndMmsi(int userId, int loginUserId, String productId, String shipName, String mmsi, int id, String equipmentId, Pageable pageable) {
        return shipsDao.findByProductIdAndEquipmentIdAndNameAndIdAndMmsi(userId, loginUserId, productId, shipName, mmsi, id, equipmentId, pageable);
    }

    @Override
    public Page<Ships> findByProductIdAndUserIdAndLoginUserId(int userId, int loginUserId, String productId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByProductIdAndUserIdAndLoginUserId(userId, loginUserId, productId, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByMmsiIdAndUserIdAndLoginUserId(int userId, int loginUserId, String mmsi, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByMmsiIdAndUserIdAndLoginUserId(userId, loginUserId, mmsi, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findByNameAndUserIdAndLoginUserId(int userId, int loginUserId, String shipName, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findByNameAndUserIdAndLoginUserId(userId, loginUserId, shipName, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findBindedShipsByProductId(String productId, int userId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findBindedShipsByProductId(productId, userId, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findBindedShipsByShipName(String shipName, int userId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findBindedShipsByShipName(shipName, userId, pageable);
        return new PageImpl<Ships>(shipsPage.getContent(), pageable, shipsPage.getTotalElements());
    }

    @Override
    public Page<Ships> findBindedShipsByEquipmentId(String equipmentId, int userId, Pageable pageable) {
        Page<Ships> shipsPage = shipsDao.findBindedShipsByEquipmentId(equipmentId, userId, pageable);
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
