package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.ShipTeam;
import com.ctbt.ctbtweb.entity.ShipTeamMember;
import com.ctbt.ctbtweb.entity.ShipTeamMemberId;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.forms.ShipTeamForm;
import com.ctbt.ctbtweb.service.ShipTeamMemberService;
import com.ctbt.ctbtweb.service.ShipTeamService;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.vo.ShipGroupMemberVO;
import com.ctbt.ctbtweb.vo.ShipsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shipTeam")
@Slf4j
public class ShipTeamController {
    @Resource
    private ShipTeamService shipTeamService;
    @Resource
    private ShipTeamMemberService shipTeamMemberService;
    @Resource
    private ShipsService shipsService;

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

    @PutMapping("/editShipTeam")
    public ServerResponse editShipTeam(@Valid ShipTeamForm shipTeamForm, BindingResult bindingResult,
                                       @RequestParam(value = "shipTeamId") int shipTeamId) {
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        ShipTeam shipTeam = shipTeamService.findById(shipTeamId);
        ShipTeam result = shipTeamService.save(shipTeamForm.getTeamLeaderShipId(), shipTeam.getTeamName(),
                shipTeam.getSafeDistance());
        return ServerResponse.success(result);
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

    /**
     * @param shipGroupId shipGroupId
     * @param shipId      shipId
     * @param workStatus  作业状态（1作业2停航3修船）
     * @return 绑定船舶到编组
     */
    @PostMapping("/addShipToShipGroup")
    public ServerResponse addShipToShipGroup(@RequestParam(value = "shipGroupId") int shipGroupId,
                                             @RequestParam("shipId") int shipId,
                                             @RequestParam("workStatus") String workStatus) {
        ShipTeamMember shipTeamMember = new ShipTeamMember(new ShipTeamMemberId(shipId, shipGroupId), "1");
        ShipTeamMember result = shipTeamMemberService.save(shipTeamMember);
        return ServerResponse.success("船舶绑定成功", result);
    }

    /**
     * @param shipGroupId shipGroupId
     * @return 该编组下的船舶列表
     */
    @GetMapping("/shipGroupId/{shipGroupId}/shipList")
    public ServerResponse shipList(@PathVariable(value = "shipGroupId") int shipGroupId,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<ShipTeamMember> shipTeamPage = shipTeamMemberService.findByShipTeamMemberIdTeamId(shipGroupId, request);

//        List<Ships> shipsList = shipTeamPage.getContent().stream().map(shipTeamMember -> shipsService.
//        findById(shipTeamMember.getShipTeamMemberId().getShipId())).collect(Collectors.toList());

        List<ShipGroupMemberVO> shipsList = shipTeamPage.getContent().stream().map(shipTeamMember -> {
            ShipGroupMemberVO shipGroupMemberVO = new ShipGroupMemberVO();
            ShipsVO shipsVO = new ShipsVO();
            BeanUtils.copyProperties(shipsService.findById(shipTeamMember.getShipTeamMemberId().getShipId()), shipsVO);
//            shipGroupMemberVO.setShips(shipsService.findById(shipTeamMember.getShipTeamMemberId().getShipId()));
            shipGroupMemberVO.setShipsVO(shipsVO);
            shipGroupMemberVO.setShipGroupId(shipTeamMember.getShipTeamMemberId().getTeamId());
            shipGroupMemberVO.setWorkStatus(shipTeamMember.getWorkStatus());
            return shipGroupMemberVO;
        }).collect(Collectors.toList());
/*
        List<ShipGroupMemberVO> shipsList = shipTeamPage.getContent().stream().map(shipTeamMember -> new ShipGroupMemberVO(
                shipsService.findById(shipTeamMember.getShipTeamMemberId().getShipId()),
                shipTeamMember.getShipTeamMemberId().getTeamId(), shipTeamMember.getWorkStatus())
        ).collect(Collectors.toList());
*/
        return ServerResponse.success(shipsList);
    }

    /**
     * @param shipGroupId shipGroupId
     * @param shipId      shipId
     * @return 删除该编组下的某条船舶
     */
    @DeleteMapping("/deleteShipToShipGroup")
    public ServerResponse deleteShipToShipGroup(@RequestParam(value = "shipGroupId") int shipGroupId,
                                                @RequestParam("shipId") int shipId) {
        ShipTeamMember shipTeamMember = shipTeamMemberService.findByShipTeamMemberId(new ShipTeamMemberId(shipId, shipGroupId));
        if (shipTeamMember == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        try {
            shipTeamMemberService.delete(shipTeamMember);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
//            e.printStackTrace();
            return ServerResponse.failByMsg("删除失败");
        }
    }
}
