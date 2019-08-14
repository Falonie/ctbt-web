package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsToUsersService {
    Page<ShipsToUsers> findByUserId(int userId, Pageable pageable);
}
