package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.Nation;

import java.util.List;

public interface NationService {
    Nation save(Nation nation);

    Nation findOne(int id);

    Nation findOneByName(String name);

    int deleteByNationId(int nationId);

    List<Nation> findAll();
}
