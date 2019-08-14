package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    City save(City city);

    List<City> getAll();

    Page<City> findAll(Pageable pageable);

    City getCityByCityName(String cityName);

    City getCityByCityId(int cityId);

    List<City> getAllByProvinceName(String ProvinceName);

    List<City> getCitiesByProvinceId(int provinceId);

    void deleteCityByCityName(String cityName);

    void delete(City city);
}
