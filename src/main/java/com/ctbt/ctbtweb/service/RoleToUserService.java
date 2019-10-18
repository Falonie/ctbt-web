package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.RoleToUser;

import java.util.List;

public interface RoleToUserService {
    List<RoleToUser> findAllByRoleId(int roleId);

    RoleToUser findByUserIdAndRoleId(int userId, int roleId);

    RoleToUser save(RoleToUser roleToUser);

    void delete(RoleToUser roleToUser);

//    List<RoleToUser> findAllByRoleIdNot(int roleId);
}
