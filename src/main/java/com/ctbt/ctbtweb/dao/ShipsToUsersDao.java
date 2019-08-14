package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.ShipsToUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipsToUsersDao extends JpaRepository<ShipsToUsers, Integer> {
    Page<ShipsToUsers> findByUserId(int userId, Pageable pageable);
}
