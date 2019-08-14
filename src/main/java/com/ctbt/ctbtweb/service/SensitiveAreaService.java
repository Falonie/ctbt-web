package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.SensitiveArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SensitiveAreaService {
    Page<SensitiveArea> findSensitiveAreas(Pageable pageable);

    Page<SensitiveArea> findSensitiveAreasByUserId(int userId, Pageable pageable);
}
