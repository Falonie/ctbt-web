package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.RoleToUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleToUserDao extends JpaRepository<RoleToUser, Integer> {
    List<RoleToUser> findAllByRoleId(int roleId);

    List<RoleToUser> findAllByRoleIdNot(int roleId);

    RoleToUser findByUserIdAndRoleId(int userId, int roleId);
}
