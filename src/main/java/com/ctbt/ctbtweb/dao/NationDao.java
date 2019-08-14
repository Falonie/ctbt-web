package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationDao extends JpaRepository<Nation, Integer> {
    Nation getNationByName(String name);

    Nation getNationByNationId(int nationId);

    Nation findNationByNationId(int nationId);

    int deleteByNationId(int nationId);
}
