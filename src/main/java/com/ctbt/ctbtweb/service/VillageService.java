package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.Village;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VillageService {
    Village save(Village village);

    void delete(Village village);

    Village update(Village village);

    Village findById(int id);

    Page<Village> findAll(Pageable pageable);
}
