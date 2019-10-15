package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.RoleToUser;

import java.util.List;

public interface RoleToUserService {
    List<RoleToUser> findAllByRoleId(int roleId);

//    List<RoleToUser> findAllByRoleIdNot(int roleId);
}
