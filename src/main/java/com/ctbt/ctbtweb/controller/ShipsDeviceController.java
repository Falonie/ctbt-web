package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsDevice;
import com.ctbt.ctbtweb.service.ShipsDeviceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shipsDevice")
public class ShipsDeviceController {
    @Resource
    private ShipsDeviceService shipsDeviceService;

    /**
     * 输入设备ID查询船舶
     *
     * @param deviceId
     * @param page
     * @param size     10
     * @return
     */

    @GetMapping("/shipsDeviceList")
    public ServerResponse shipsDeviceList(@RequestParam(value = "deviceId") String deviceId,
                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                          @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, 10);
//        Page<ShipsDevice> shipsDevicePage = shipsDeviceService.findByShipsDeviceId(String.valueOf(deviceId), request);
        Page<ShipsDevice> shipsDevicePage = shipsDeviceService.findByShipsDeviceId(deviceId, request);
        System.out.println("***************" + shipsDevicePage.getTotalElements() + "*********" + shipsDevicePage.getTotalPages() + "********" + shipsDevicePage.getContent());
        if (shipsDevicePage.getContent().isEmpty()) {
            return ServerResponse.successByMsg("对应船舶不存在");
        }
        List<Ships> shipsList = shipsDevicePage.getContent().stream().map(ShipsDevice::getShips).collect(Collectors.toList());
        return ServerResponse.success(shipsList);
    }
}
