package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Province;
import com.ctbt.ctbtweb.forms.ProvinceForm;
import com.ctbt.ctbtweb.service.NationService;
import com.ctbt.ctbtweb.service.ProvinceService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private NationService nationService;

    @GetMapping(value = "/list")
    public ServerResponse provinceList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
//        List<Province> provinceList = provinceService.findAll();
        PageRequest request = PageRequest.of(page, 10);
        Page<Province> provincePage = provinceService.findAll(request);
        System.out.println("**********" + provincePage.getContent() + "**********");
        return ServerResponse.success(provincePage.getContent());
    }

    @PostMapping(value = "/addProvince")
    public ServerResponse addProvince(@Valid ProvinceForm provinceForm, BindingResult bindingResult) {
        Province province = new Province();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(provinceForm, province);
        province.setNation(nationService.findOne(86));
        Province result = provinceService.save(province);
        return ServerResponse.success(result);
    }

    @DeleteMapping(value = "/deleteProvince")
    public ServerResponse deleteProvince(@RequestParam("provinceId") int provinceId) {
        Province province = provinceService.findProvinceByProvinceId(provinceId);
        if (province == null) {
            return ServerResponse.failByMsg("该省份不存在");
        }
        provinceService.delete(province);
        return ServerResponse.successByMsg("删除成功");
    }
}
