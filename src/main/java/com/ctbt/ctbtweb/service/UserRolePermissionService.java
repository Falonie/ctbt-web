package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.UserRolePermission;
import com.ctbt.ctbtweb.entity.UserRolePermissionId;

import java.util.List;

public interface UserRolePermissionService {
    UserRolePermission save(UserRolePermission userRolePermission);

    void delete(UserRolePermission userRolePermission);

    UserRolePermission findByUserRolePermissionId(UserRolePermissionId userRolePermissionId);

    List<UserRolePermission> findByUserRolePermissionIdUrId(int urId);

    List<UserRolePermission> findByUserRolePermissionIdPermId(int permId);

    List<UserRolePermission> findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(int urId, String permType);
}
