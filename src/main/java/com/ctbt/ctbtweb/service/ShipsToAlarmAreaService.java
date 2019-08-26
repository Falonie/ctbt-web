package com.ctbt.ctbtweb.service;

import com.ctbt.ctbtweb.entity.AlarmArea;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsToAlarmArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipsToAlarmAreaService {
    ShipsToAlarmArea save(ShipsToAlarmArea shipsToAlarmArea);

    ShipsToAlarmArea findById(int id);

    ShipsToAlarmArea findByShipIdOrAreaId(int shipId, int areaId);

    Page<ShipsToAlarmArea> findAll(Pageable pageable);

    void delete(ShipsToAlarmArea shipsToAlarmArea);

    ShipsToAlarmArea addShipToAlarmArea(Ships ships, AlarmArea alarmArea);
}
