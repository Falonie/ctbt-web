package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsService {
    Ships save(Ships ships);

    Ships update(Ships ships);

    Ships findById(int id);

    Page<Ships> findAll(Pageable pageable);

    Page<Ships> findByDeviceId(int equipmentId, int mmsi,Pageable pageable);

    void delete(Ships ships);
}
