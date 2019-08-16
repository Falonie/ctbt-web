package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsService {
    Ships save(Ships ships);

    Ships update(Ships ships);

    Ships findById(int id);

    Ships findByName(String shipName);

    Ships findByIdOrName(int id, String name);

    Page<Ships> findAll(Pageable pageable);

    Page<Ships> findByDeviceId(int equipmentId, int mmsi, Pageable pageable);

    Page<Ships> findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
            String nation, String province, String city, String county, int userId, Pageable pageable
    );

    void delete(Ships ships);
}
