package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Permission;

public interface PermissionService {
    Permission save(Permission permission);

    Permission findByPermId(int permId);

    void delete(Permission permission);
}
