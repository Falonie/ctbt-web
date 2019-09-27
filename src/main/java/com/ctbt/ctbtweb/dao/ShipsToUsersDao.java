package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipsToUsersDao extends JpaRepository<ShipsToUsers, Integer> {
    Page<ShipsToUsers> findByUserId(int userId, Pageable pageable);

    List<ShipsToUsers> findByShipId(int shipId);

    ShipsToUsers findByUserIdAndShipId(int userId, int shipId);
}
