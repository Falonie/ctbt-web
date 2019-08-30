package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.PushData;
import com.ctbt.ctbtweb.forms.PushDataForm;
import com.ctbt.ctbtweb.service.PushDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/pushData")
@Slf4j
public class PushDataController {
    @Resource
    private PushDataService pushDataService;

    @GetMapping("/pushDataList")
    public ServerResponse pushDataList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<PushData> pushDataPage = pushDataService.findAll(request);
        return ServerResponse.success(pushDataPage.getContent());
    }

    @GetMapping("/findPushData/id/{id}")
    public ServerResponse findPushData(@PathVariable("id") int id) {
        PushData pushData = pushDataService.findById(id);
        if (pushData == null) {
            return ServerResponse.failByMsg("该推送不存在");
        }
        return ServerResponse.success(pushData);
    }

    @PostMapping("/addPushData")
    public ServerResponse addPushData(@Valid PushDataForm pushDataForm, BindingResult bindingResult) {
        PushData pushData = new PushData();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(pushDataForm, pushData);
        PushData result = pushDataService.save(pushData);
        return ServerResponse.success(result);
    }

    @PutMapping("/editPushData/id/{id}")
    public ServerResponse editPushData(@PathVariable("id") int id,
                                       @Valid PushDataForm pushDataForm, BindingResult bindingResult) {
        PushData pushData = pushDataService.findById(id);
        if (pushData == null) {
            return ServerResponse.failByMsg("该推送不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(pushDataForm, pushData);
        PushData result = pushDataService.save(pushData);
        return ServerResponse.success(result);
    }

    @DeleteMapping("/deletePushData")
    public ServerResponse deletePushData(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        PushData pushData = pushDataService.findByIdOrName(id, name);
        if (pushData == null) {
            return ServerResponse.failByMsg("该推送不存在");
        }
        try {
            pushDataService.delete(pushData);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            return ServerResponse.failByMsg("删除失败");
        }
    }
}
