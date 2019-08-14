package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.SensitiveArea;
import com.ctbt.ctbtweb.service.SensitiveAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sensitiveArea")
public class SensitiveAreaController {
    @Resource
    private SensitiveAreaService sensitiveAreaService;

    @GetMapping("/listAll")
    public ServerResponse allSensitiveAreaService(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, 10);
        Page<SensitiveArea> sensitiveAreaPage = sensitiveAreaService.findSensitiveAreas(request);
        return ServerResponse.success(sensitiveAreaPage.getContent());
    }

    @GetMapping("/list")
    public ServerResponse sensitiveAreaServiceByUserId(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                       @RequestParam(value = "id") int id) {
        PageRequest request = PageRequest.of(page, 10);
        Page<SensitiveArea> sensitiveAreaPage = sensitiveAreaService.findSensitiveAreasByUserId(id,request);
        return ServerResponse.success(sensitiveAreaPage.getContent());
    }
}
