package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipTypeDao extends JpaRepository<ShipType, Integer> {
    ShipType findById(int id);

    ShipType findByTypeName(String name);

    ShipType findByIdOrTypeName(int id, String name);
}
