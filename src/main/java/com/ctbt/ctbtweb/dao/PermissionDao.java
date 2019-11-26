package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Integer> {
    Permission findByPermId(int permId);
}
