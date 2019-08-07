package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.County;

import java.util.List;

public interface CountyService {
    County save(County county);

    County findCountyByCountyName(String countyName);

    List<County> findCountiesByCityId(int cityId);

    County findCountyByCountyId(int countyId);
}
