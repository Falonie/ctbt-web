package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.PushData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PushDataService {
    List<PushData> findAll();

    Page<PushData> findAll(Pageable pageable);

//    List<PushData> findByName(String name);

    PushData findById(int id);

    List<PushData> findByName(String name);

    PushData findByIdOrName(int id, String name);

    PushData save(PushData pushData);

    PushData update(PushData pushData);

    void delete(PushData pushData);
}
