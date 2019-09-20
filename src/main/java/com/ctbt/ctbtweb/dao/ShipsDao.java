package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipsDao extends JpaRepository<Ships, Integer> {
    Ships findById(int id);

    Ships findByName(String shipName);

    Ships findByIdOrName(int id, String name);

    Ships findByMmsi(String mmsi);

    Ships findByCardNo(int cardNo);

    Ships findByEquipmentId(String equipmentId);

    Page<Ships> findByEquipmentIdOrMmsi(String equipmentId, String mmsi, Pageable pageable);

    Page<Ships> findByNationLikeOrProvinceLikeOrCityLike(String nation, String province, String city, Pageable pageable);

    @Query(value = "select * from SHIPS_TABLE where NATION like %:nation% and PROVINCE like %:province% " +
            "and CITY like %:city% and COUNTY like %:county% and ID in (select SHIPID from SHIPSTOUSERS_TABLE " +
            "where USERID=:userId)", nativeQuery = true)
    Page<Ships> findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
            String nation, String province, String city, String county, int userId, Pageable pageable
    );

    @Query(value = "select * from SHIPS_TABLE where ID in " +
            "(select SHIPID from SHIPSTOUSERS_TABLE where USERID=:userId) and ISUNPOWER=:isUnpower", nativeQuery = true)
    Page<Ships> findByIsUnpowerAndUserId(int userId, String isUnpower, Pageable pageable);
}
