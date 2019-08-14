package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipsDao extends JpaRepository<Ships, Integer> {
    Ships findById(int id);

    Ships findByName(String shipName);

    Ships findByMmsi(String mmsi);

    Ships findByCardNo(int cardNo);

    Page<Ships> findByEquipmentidOrMmsi(String equipmentid, String mmsi, Pageable pageable);
}
