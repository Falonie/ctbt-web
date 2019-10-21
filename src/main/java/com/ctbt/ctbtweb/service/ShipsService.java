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

    Ships findByEquipmentId(String equipmentId);

    Page<Ships> findAll(Pageable pageable);

    Page<Ships> findByDeviceId(int equipmentId, int mmsi, Pageable pageable);

    Page<Ships> findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
            String nation, String province, String city, String county, int userId, Pageable pageable
    );

//    Page<Ships> findByUserIdAndIsUnPowerShips()

    Page<Ships> findByIsUnpowerAndUserId(int userId, Pageable pageable);

    Page<Ships> findByProductIdAndEquipmentIdAndNameAndIdAndMmsi(
            int userId, int loginUserId, String productId, String shipName, String mmsi, int id, String equipmentId, Pageable pageable
    );

    Page<Ships> findByProductIdAndUserIdAndLoginUserId(
            int userId, int loginUserId, String productId, Pageable pageable
    );

    Page<Ships> findByMmsiIdAndUserIdAndLoginUserId(
            int userId, int loginUserId, String mmsi, Pageable pageable
    );

    Page<Ships> findByNameAndUserIdAndLoginUserId(
            int userId, int loginUserId, String shipName, Pageable pageable
    );

    void delete(Ships ships);

    void addShipToSensitiveArea(Ships ships);
}
