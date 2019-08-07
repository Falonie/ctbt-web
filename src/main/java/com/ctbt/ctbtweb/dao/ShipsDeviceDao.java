package com.ctbt.ctbtweb.dao;

import com.ctbt.ctbtweb.domain.ShipsDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipsDeviceDao extends JpaRepository<ShipsDevice, Integer> {
    Page<ShipsDevice> findAllByDeviceId(String id, Pageable pageable);

//    List<ShipsDevice> findAllByDeviceId(String id);

    Page<ShipsDevice> findByShipsId(int shipsId, Pageable pageable);
}
