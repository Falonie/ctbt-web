package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.ShipTeam;
import com.ctbt.ctbtweb.forms.ShipTeamForm;
import com.ctbt.ctbtweb.service.ShipTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/shipTeam")
@Slf4j
public class ShipTeamController {
    @Resource
    private ShipTeamService shipTeamService;

    @GetMapping("/id/{id}")
    public ServerResponse findShipTeam(@PathVariable(value = "id") int id) {
        ShipTeam shipTeam = shipTeamService.findById(id);
        if (shipTeam == null) {
            return ServerResponse.failByMsg("该编组不存在");
        }
        return ServerResponse.success(shipTeam);
    }

    @GetMapping("/shipTeamList")
    public ServerResponse shipTeamList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<ShipTeam> shipTeamPage = shipTeamService.findAll(request);
        return ServerResponse.success(shipTeamPage);
    }

    @PostMapping("/saveShipTeam")
    public ServerResponse saveShipTeam(@Valid ShipTeamForm shipTeamForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        ShipTeam shipTeam = shipTeamService.save(shipTeamForm.getTeamLeaderShipId(), shipTeamForm.getTeamName(),
                shipTeamForm.getSafeDistance());
        return ServerResponse.success(shipTeam);
    }

    @DeleteMapping("/delete/id/{id}")
    public ServerResponse deleteShipTeam(@PathVariable(value = "id") int teamId) {
        ShipTeam shipTeam = shipTeamService.findById(teamId);
        if (shipTeam == null) {
            return ServerResponse.failByMsg("该编组不存在");
        }
        shipTeamService.delete(shipTeam);
        return ServerResponse.successByMsg("删除成功");
    }
}
