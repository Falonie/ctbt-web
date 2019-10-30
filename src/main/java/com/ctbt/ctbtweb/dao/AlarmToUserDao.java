package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmToUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmToUserDao extends JpaRepository<AlarmToUser, Integer> {
    Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable);
}
