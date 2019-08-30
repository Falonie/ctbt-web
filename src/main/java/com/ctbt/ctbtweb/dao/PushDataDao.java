package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.entity.PushData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PushDataDao extends JpaRepository<PushData, Integer> {
    PushData findByIdOrName(int id, String name);

    Page<PushData> findAll(Pageable pageable);

    List<PushData> findByName(String name);
}
