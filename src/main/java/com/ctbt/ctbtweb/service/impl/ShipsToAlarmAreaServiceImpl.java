package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.ShipsToAlarmAreaDao;
import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsToAlarmArea;
import com.ctbt.ctbtweb.service.ShipsToAlarmAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("shipsToAlarmAreaService")
public class ShipsToAlarmAreaServiceImpl implements ShipsToAlarmAreaService {
    @Resource
    private ShipsToAlarmAreaDao shipsToAlarmAreaDao;

    @Override
    public ShipsToAlarmArea save(ShipsToAlarmArea shipsToAlarmArea) {
        return shipsToAlarmAreaDao.save(shipsToAlarmArea);
    }

    @Override
    public ShipsToAlarmArea findById(int id) {
        return shipsToAlarmAreaDao.findById(id).orElse(null);
    }

    @Override
    public ShipsToAlarmArea findByShipIdOrAreaId(int shipId, int areaId) {
        return shipsToAlarmAreaDao.findByShipIdOrAreaId(shipId, areaId);
    }

    @Override
    public Page<ShipsToAlarmArea> findAll(Pageable pageable) {
        Page<ShipsToAlarmArea> shipsToAlarmAreaPage = shipsToAlarmAreaDao.findAll(pageable);
        return new PageImpl<ShipsToAlarmArea>(shipsToAlarmAreaPage.getContent(), pageable, shipsToAlarmAreaPage.getTotalElements());
    }

    @Override
    public void delete(ShipsToAlarmArea shipsToAlarmArea) {
        shipsToAlarmAreaDao.delete(shipsToAlarmArea);
    }

    @Override
    public ShipsToAlarmArea addShipToAlarmArea(Ships ships, AlarmArea alarmArea) {
        return null;
    }
}
