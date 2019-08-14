package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipTypeDao;
import com.ctbt.ctbtweb.entity.ShipType;
import com.ctbt.ctbtweb.service.ShipTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipTypeService")
public class ShipTypeServiceImpl implements ShipTypeService {
    @Resource
    private ShipTypeDao shipTypeDao;

    @Override
    public ShipType findById(int id) {
        return shipTypeDao.findById(id);
    }

    @Override
    public ShipType findByName(String name) {
        return shipTypeDao.findByTypeName(name);
    }

    @Override
    public ShipType findByIdOrTypeName(int id, String name) {
        return shipTypeDao.findByIdOrTypeName(id, name);
    }

    @Override
    public Page<ShipType> findAll(Pageable pageable) {
        Page<ShipType> shipTypePage = shipTypeDao.findAll(pageable);
        return new PageImpl<ShipType>(shipTypePage.getContent(), pageable, shipTypePage.getTotalElements());
    }
}
