package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.TownDao;
import com.ctbt.ctbtweb.entity.Town;
import com.ctbt.ctbtweb.service.TownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("townService")
public class TownServiceImpl implements TownService {
    @Resource
    private TownDao townDao;

    @Override
    public Town save(Town town) {
        return townDao.save(town);
    }

    @Override
    public Town findTownByTownName(String townName) {
        return townDao.findByName(townName);
    }

    @Override
    public Town findTownByTownId(int townId) {
        return townDao.findById(townId);
    }

    @Override
    public List<Town> getTownListByCountyId(int countId) {
        return townDao.findByCountyId(countId);
    }
}
