package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipsToUsersDao extends JpaRepository<ShipsToUsers, Integer> {
    Page<ShipsToUsers> findByUserId(int userId, Pageable pageable);

    List<ShipsToUsers> findByShipId(int shipId);

    ShipsToUsers findByUserIdAndShipId(int userId, int shipId);

    @Query(value = "select * from SHIPSTOUSERS_TABLE su where su.USERID=:userId and su.SHIPID like %:shipId%",nativeQuery = true)
    Page<ShipsToUsers> findByUserIdAndShipIdLike(int userId, int shipId, Pageable pageable);
}
