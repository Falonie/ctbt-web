package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.AlarmType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmTypeDao extends JpaRepository<AlarmType, String> {
}
