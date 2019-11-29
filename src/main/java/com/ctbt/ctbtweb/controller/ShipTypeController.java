package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.ShipType;
import com.ctbt.ctbtweb.service.ShipTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class ShipTypeController {
    @Resource
    private ShipTypeService shipTypeService;

/*
    @GetMapping("/shipType")
    public ServerResponse shipType(@RequestParam(value = "id") int id) {
        ShipType shipType = shipTypeService.findById(id);
        if (shipType == null) {
            return ServerResponse.failByMsg("无此船舶类型");
        }
        return ServerResponse.success(shipType);
    }
*/

    @GetMapping("/shipType")
    public ServerResponse shipType(@RequestParam(value = "id", defaultValue = "0") int id,
                                   @RequestParam(value = "typeName", defaultValue = "") String typeName) {
        ShipType shipType = shipTypeService.findByIdOrTypeName(id, typeName);
        if (shipType == null) {
            return ServerResponse.failByMsg("无此船舶类型");
        }
        return ServerResponse.success(shipType);
    }

    @GetMapping("/shipTypeList")
    public ServerResponse shipTypeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<ShipType> shipTypePage = shipTypeService.findAll(request);
        if (shipTypePage.getContent().isEmpty()) {
            return ServerResponse.failByMsg("");
        }
        return ServerResponse.success(shipTypePage.getContent());
    }
}
