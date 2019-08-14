package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipsDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsDeviceService {
    Page<ShipsDevice> findByShipsDeviceId(String deviceId, Pageable pageable);

//    List<ShipsDevice> findByShipsDeviceId(String id);
    Page<ShipsDevice> findByShipsId(int shipId, Pageable pageable);
}
