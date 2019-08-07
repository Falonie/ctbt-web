package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TownDao extends JpaRepository<Town, Integer> {
    Town findByName(String Name);

    Town findById(int id);

    List<Town> findByCountyId(int countyId);
}
