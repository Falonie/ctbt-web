package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Ships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipsDao extends JpaRepository<Ships, Integer> {
    Ships findById(int id);

    List<Ships> findByIdIn(List<Integer> shipIdList);

    Ships findByName(String shipName);

    Ships findByIdOrName(int id, String name);

    Ships findByMmsi(String mmsi);

    Ships findByCardNo(int cardNo);

    Ships findByEquipmentId(String equipmentId);

    Ships findByProductId(String productId);

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

    @Query(value = "select * from SHIPS_TABLE s where (s.ID not in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)" +
            " and s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:loginUserId))" +
            " and (s.PRODUCTID like %:productId% and s.NAME like %:shipName% and s.MMSI like %:mmsi% " +
            " and s.ID like %:id% and s.EQUIPMENTID like %:equipmentId%)", nativeQuery = true)
    Page<Ships> findByProductIdAndEquipmentIdAndNameAndIdAndMmsi(
            int userId, int loginUserId, String productId, String shipName, String mmsi, int id, String equipmentId, Pageable pageable
    );

    @Query(value = "select * from SHIPS_TABLE where (ID not in (select SHIPID from SHIPSTOUSERS_TABLE where USERID=:userId)" +
            " and ID in (select SHIPID from SHIPSTOUSERS_TABLE where USERID=:loginUserId))" +
            " and (PRODUCTID like %:productId%)"
            , nativeQuery = true)
    Page<Ships> findByProductIdAndUserIdAndLoginUserId(
            int userId, int loginUserId, String productId, Pageable pageable
    );

    @Query(value = "select * from SHIPS_TABLE s where (s.ID not in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)" +
            " and s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:loginUserId))" +
            " and (s.MMSI like %:mmsi%)"
            , nativeQuery = true)
    Page<Ships> findByMmsiIdAndUserIdAndLoginUserId(
            int userId, int loginUserId, String mmsi, Pageable pageable
    );

    @Query(value = "select * from SHIPS_TABLE s where (s.ID not in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)" +
            " and s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:loginUserId))" +
            " and (s.NAME like %:shipName%)"
            , nativeQuery = true)
    Page<Ships> findByNameAndUserIdAndLoginUserId(
            int userId, int loginUserId, String shipName, Pageable pageable
    );

    @Query(value = "select * from SHIPS_TABLE s where s.PRODUCTID like %:productId% and " +
            "s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)", nativeQuery = true)
    Page<Ships> findBindedShipsByProductId(String productId, int userId, Pageable pageable);

    @Query(value = "select * from SHIPS_TABLE s where s.NAME like %:shipName% and " +
            "s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)", nativeQuery = true)
    Page<Ships> findBindedShipsByShipName(String shipName, int userId, Pageable pageable);

    @Query(value = "select * from SHIPS_TABLE s where s.EQUIPMENTID like %:equipmentId% and " +
            "s.ID in (select su.SHIPID from SHIPSTOUSERS_TABLE su where su.USERID=:userId)", nativeQuery = true)
    Page<Ships> findBindedShipsByEquipmentId(String equipmentId, int userId, Pageable pageable);
}
