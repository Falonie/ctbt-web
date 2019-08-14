package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.SensitiveArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensitiveAreaDao extends JpaRepository<SensitiveArea, Integer> {
    Page<SensitiveArea> findByUserId(int userId, Pageable pageable);
}
