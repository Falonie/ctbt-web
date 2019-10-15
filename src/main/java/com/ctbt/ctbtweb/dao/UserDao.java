package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    User findByUsernameAndPassword(String name, String password);

    User findByIdOrUsername(int id, String username);

    @Query(value = "select * from USER_TABLE u where u.ID not in (select c.USERID from CTBT_USER_ROLE c where c.ROLEID=:roleId)", nativeQuery = true)
//    @Query(value = "select * from USER_TABLE u where u.ID not in (select c.USERID from CTBT_USER_ROLE c where c.ROLEID=:roleId)",nativeQuery = false)
    Page<User> findAllByTypeNotInRoleId(int roleId, Pageable pageable);

//    Page<User> findUsers(Pageable pageable);
}
