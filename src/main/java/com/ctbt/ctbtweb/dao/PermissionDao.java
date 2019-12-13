package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission, Integer> {
    Permission findByPermId(int permId);

    List<Permission> findByPermIdIn(List<Integer> permIdList);
}
