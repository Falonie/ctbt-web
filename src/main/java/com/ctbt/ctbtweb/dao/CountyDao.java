package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyDao extends JpaRepository<County, Integer> {
    County findByName(String countyName);

    County findByCountyId(int countyId);

    List<County> findByCityId(int cityId);
}
