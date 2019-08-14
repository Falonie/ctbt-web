package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Town;

import java.util.List;

public interface TownService {
    Town save(Town town);

    Town findTownByTownName(String townName);

    Town findTownByTownId(int townId);

    List<Town> getTownListByCountyId(int countId);
}
