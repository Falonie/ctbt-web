package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Permission;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    Permission findByPermId(int permId);

    List<Permission> findByPermIdIn(List<Integer> permIdList);

    void delete(Permission permission);
}
