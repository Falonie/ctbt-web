package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.CountyDao;
import com.ctbt.ctbtweb.domain.County;
import com.ctbt.ctbtweb.service.CountyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("countyService")
public class CountyServiceImpl implements CountyService {
    @Resource
    private CountyDao countyDao;

    @Override
    public County save(County county) {
        return countyDao.save(county);
    }

    @Override
    public County findCountyByCountyName(String countyName) {
        return countyDao.findByName(countyName);
    }

    @Override
    public List<County> findCountiesByCityId(int cityId) {
        return countyDao.findByCityId(cityId);
    }

    @Override
    public County findCountyByCountyId(int countyId) {
        return countyDao.findByCountyId(countyId);
    }
}
