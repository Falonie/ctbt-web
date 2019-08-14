package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.ShipForm;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import com.ctbt.ctbtweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ships")
@Slf4j
public class ShipsController {
    @Resource
    private ShipsService shipsService;
    @Resource
    private UserService userService;
    @Resource
    private ShipsToUsersService shipsToUsersService;

    @GetMapping("/allShipsList")
    public ServerResponse allShipsList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page, 10);
        Page<Ships> shipsPage = shipsService.findAll(request);
        return ServerResponse.success(shipsPage.getContent());
    }

    /**
     * 显示当前用户的船舶
     * @param page 页码
     * @param size 每页显示数量
     * @param id 用户id
     * @param username 用户名
     * @param session
     * @return 船舶列表
     */
    @GetMapping("/list")
    public ServerResponse shipsList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    @RequestParam(value = "id", required = false, defaultValue = "0") int id,
                                    @RequestParam(value = "username", required = false) String username, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findByIdOrUsername(id, username);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        PageRequest request = PageRequest.of(page, 10);
        Page<ShipsToUsers> shipsToUsersPage = shipsToUsersService.findByUserId(id, request);
        List<Ships> shipsList = shipsToUsersPage.getContent().stream().map(e -> shipsService.findById(e.getShipId())).collect(Collectors.toList());
        return ServerResponse.success(shipsList);
    }

    @GetMapping
    public ServerResponse ship(@RequestParam("id") int id) {
        Ships ships = shipsService.findById(id);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        return ServerResponse.success(ships);
    }

    @PostMapping("/addShip")
    public ServerResponse addShip(@Valid ShipForm shipForm, BindingResult bindingResult) {
        Ships ships = new Ships();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(shipForm, ships);
        Ships result = shipsService.save(ships);
        return ServerResponse.success(result);
    }

    @PutMapping("/edit")
    public ServerResponse editShip(@RequestParam("id") int id, @Valid ShipForm shipForm, BindingResult bindingResult) {
        Ships ships = shipsService.findById(id);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(shipForm, ships);
        Ships result = shipsService.save(ships);
        return ServerResponse.success(result);
    }
}
