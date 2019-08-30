package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Log;
import com.ctbt.ctbtweb.service.LogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log")
public class LogController {
    @Resource
    private LogService logService;

    @RequestMapping("/logList")
    public ServerResponse logList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size,
                                  @RequestParam(value = "type", required = false) String type,
                                  @RequestParam(value = "clientType", required = false) String clientType,
                                  @RequestParam(value = "ipAddress", required = false) String ipAddress,
                                  @RequestParam(value = "macAddress", required = false) String macAddress,
                                  @RequestParam(value = "startDate", required = false) String startDate,
                                  @RequestParam(value = "endDate", required = false) String endDate) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Log> logPage = logService.findByTypeOrClientTypeOrIpAddressOrMacAddressOrDateBetweenStartAndEnd(
                type, clientType, ipAddress, macAddress, startDate, endDate, request);
        return ServerResponse.success(logPage.getContent());
    }
}
