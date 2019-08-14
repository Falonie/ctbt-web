package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipTypeService {
    ShipType findById(int id);

    ShipType findByName(String name);

    ShipType findByIdOrTypeName(int id, String name);

    Page<ShipType> findAll(Pageable pageable);
}
