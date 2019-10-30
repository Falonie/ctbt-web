package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmToUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlarmToUserService {
    Page<AlarmToUser> findAllByUserId(int userId, Pageable pageable);
}
