package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {
    City findByName(String name);

    City findByCityId(int cityId);

    List<City> findByProvinceId(int provinceId);

    void deleteByName(String cityName);
}
