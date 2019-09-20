package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.ShipsDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsDeviceService {
    ShipsDevice save(ShipsDevice shipsDevice);

    Page<ShipsDevice> findByShipsDeviceId(String deviceId, Pageable pageable);

    Page<ShipsDevice> findByShipsId(int shipId, Pageable pageable);

    void delete(ShipsDevice shipsDevice);
}
