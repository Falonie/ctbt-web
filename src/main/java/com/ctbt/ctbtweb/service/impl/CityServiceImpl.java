package com.ctbt.ctbtweb.service.impl;

import com.ctbt.ctbtweb.dao.CityDao;
import com.ctbt.ctbtweb.domain.City;
import com.ctbt.ctbtweb.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {
    @Resource
    private CityDao cityDao;

    @Override
    public City save(City city) {
        return cityDao.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityDao.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        Page<City> cityPage = cityDao.findAll(pageable);
        return new PageImpl<City>(cityPage.getContent(), pageable, cityPage.getTotalElements());
    }

    @Override
    public City getCityByCityName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public List<City> getAllByProvinceName(String ProvinceName) {
        return null;
    }

    @Override
    public List<City> getCitiesByProvinceId(int provinceId) {
        return cityDao.findByProvinceId(provinceId);
    }

    @Override
    public City getCityByCityId(int cityId) {
        return cityDao.findByCityId(cityId);
    }

    @Override
    public void deleteCityByCityName(String cityName) {
        cityDao.deleteByName(cityName);
    }

    @Override
    public void delete(City city) {
        cityDao.delete(city);
    }
}
