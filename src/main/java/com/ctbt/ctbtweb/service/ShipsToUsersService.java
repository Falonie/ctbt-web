package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShipsToUsersService {
    Page<ShipsToUsers> findByUserId(int userId, Pageable pageable);

    List<ShipsToUsers> findByShipId(int shipId);

    ShipsToUsers findByUserIdAndShipId(int userId,int shipId);

    ShipsToUsers save(ShipsToUsers shipsToUsers);

    void delete(ShipsToUsers shipsToUsers);
}
