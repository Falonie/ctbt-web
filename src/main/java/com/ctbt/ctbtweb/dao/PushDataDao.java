package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.PushData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PushDataDao extends JpaRepository<PushData, Integer> {
    List<PushData> findAll();

//    List<PushData> findByName(String name);
}
