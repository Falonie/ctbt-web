package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.UserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(int id);

    List<User> findByIdIn(List<Integer> userIdList);

    User findByUsername(String name);

    User findByIdOrUsername(int id, String username);

    User findByUsernameAndPassword(String name, String password);

    User update(User user);

    void delete(User user);

    Page<User> findAll(Pageable pageable);

    ServerResponse<User> register(UserForm userForm);

    ServerResponse<User> login(String name, String password);

    ServerResponse<String> resetPassword(String oldPassword, String newPassword, String confirmPassword, User user);

    ServerResponse checkValid(String str);

    ServerResponse editProfile(User user);

    Page<User> findAllByTypeNotInRoleId(int roleId, Pageable pageable);
}
