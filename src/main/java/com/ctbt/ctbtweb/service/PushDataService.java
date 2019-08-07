package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.domain.PushData;

import java.util.List;

public interface PushDataService {
    List<PushData> findAll();

//    List<PushData> findByName(String name);

    PushData findById(int id);

    PushData save(PushData pushData);

    PushData update(PushData pushData);

    void delete(PushData pushData);
}
