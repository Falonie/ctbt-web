package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.domain.City;
import com.ctbt.ctbtweb.forms.CityForm;
import com.ctbt.ctbtweb.forms.EditCityForm;
import com.ctbt.ctbtweb.service.CityService;
import com.ctbt.ctbtweb.service.ProvinceService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/city")
public class CityController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private CityService cityService;

    @GetMapping(value = "/list")
    public ServerResponse cityList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, 10);
        Page<City> cityPage = cityService.findAll(request);
        return ServerResponse.success(cityPage.getContent());
    }

    @PostMapping(value = "/addCity")
    public ServerResponse addCity(@RequestParam(value = "provinceId") int provinceId, @Valid CityForm cityForm, BindingResult bindingResult) {
        City city = new City();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(cityForm, city);
        city.setProvince(provinceService.findProvinceByProvinceId(provinceId));
        City result = cityService.save(city);
        return ServerResponse.success(result);
    }

    @PutMapping(value = "/editCity")
    public ServerResponse editCity(@RequestParam(value = "cityId") int cityId, @Valid EditCityForm cityForm, BindingResult bindingResult){
        City city = cityService.getCityByCityId(cityId);
        if (city == null) {
            return ServerResponse.failByMsg("该城市不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(cityForm, city);
        City result = cityService.save(city);
        return ServerResponse.success(result);
    }

    @DeleteMapping(value = "/deleteCity")
    public ServerResponse deleteCity(@RequestParam(value = "cityId") int cityId) {
        City city = cityService.getCityByCityId(cityId);
        if (city == null) {
            return ServerResponse.failByMsg("该城市不存在");
        }
        cityService.delete(city);
        return ServerResponse.successByMsg("删除成功");
    }
}
