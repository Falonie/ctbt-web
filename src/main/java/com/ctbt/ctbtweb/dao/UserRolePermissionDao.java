package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.UserRolePermission;
import com.ctbt.ctbtweb.entity.UserRolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolePermissionDao extends JpaRepository<UserRolePermission, UserRolePermissionId> {
    UserRolePermission findByUserRolePermissionId(UserRolePermissionId userRolePermissionId);

    List<UserRolePermission> findByUserRolePermissionIdUrId(int urId);

    List<UserRolePermission> findByUserRolePermissionIdPermId(int permId);

    List<UserRolePermission> findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(int urId, String permType);
}
