package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.Constant;
import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsDevice;
import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.ShipForm;
import com.ctbt.ctbtweb.forms.ShipSearchForm;
import com.ctbt.ctbtweb.service.*;
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
    @Resource
    private ShipsDeviceService shipsDeviceService;
    @Resource
    private LogService logService;

    @GetMapping("/allShipsList")
    public ServerResponse allShipsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findAll(request);
        return ServerResponse.success(shipsPage.getContent());
    }

    /**
     * 显示当前用户的船舶
     *
     * @param page     页码
     * @param size     每页显示数量
     * @param id       用户id
     * @param username 用户名
     * @param session
     * @return 船舶列表
     */
    @GetMapping("/list")
    public ServerResponse shipsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
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
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<ShipsToUsers> shipsToUsersPage = shipsToUsersService.findByUserId(user.getId(), request);
        List<Ships> shipsList = shipsToUsersPage.getContent().stream().map(e -> shipsService.findById(e.getShipId())).collect(Collectors.toList());
        return ServerResponse.success(shipsList);
    }

    /**
     * 根据给定条件搜索船舶
     *
     * @param nation
     * @param province
     * @param city
     * @param county
     * @param page
     * @param id
     * @param username
     * @param session
     * @return 返回船舶列表
     */
    @GetMapping("/searchShips")
    public ServerResponse findShipsNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
            @RequestParam(value = "nation", defaultValue = "") String nation,
            @RequestParam(value = "province", defaultValue = "") String province,
            @RequestParam(value = "city", defaultValue = "") String city,
            @RequestParam(value = "county", defaultValue = "") String county,
//            @Valid ShipSearchForm shipSearchForm,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
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
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findByNationLikeOrProvinceLikeOrCityLikeOrCountyLikeAndUserId(
                nation, province, city, county,
//                shipSearchForm.getNation(), shipSearchForm.getProvince(), shipSearchForm.getCity(), shipSearchForm.getCounty(),
                user.getId(), request);
        return ServerResponse.success(shipsPage.getContent());
    }

    /**
     * 显示当前用户的无动力船舶
     *
     * @param page
     * @param size
     * @param id
     * @param username
     * @param session
     * @return
     */
    @GetMapping("/unPowerShipsList")
    public ServerResponse unPowerShipsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
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
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findByIsUnpowerAndUserId(user.getId(), request);
        return ServerResponse.success(shipsPage.getContent());
    }

    /**
     * @param id 船舶id
     * @return 船舶
     */
    @GetMapping("/id/{id:[0-9]+}")
    public ServerResponse ship(@PathVariable("id") int id) {
        Ships ships = shipsService.findById(id);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
//        logService.save()
        return ServerResponse.success(ships);
    }

    @PostMapping("/addShip")
    public ServerResponse addShip(@Valid ShipForm shipForm, BindingResult bindingResult, HttpSession session,
                                  @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        Ships ships = new Ships();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        if (shipsService.findByEquipmentId(shipForm.getEquipmentId()) != null) {
            return ServerResponse.failByMsg("该卡号已存在");
        }
        if (shipsService.findByName(shipForm.getName()) != null) {
            return ServerResponse.failByMsg("该船舶已存在");
        }
        BeanUtils.copyProperties(shipForm, ships);
        ShipsToUsers shipsToUsers = new ShipsToUsers();
        shipsToUsers.setUserId(id);
        Ships result = shipsService.save(ships);
        shipsToUsers.setShipId(result.getId());
        shipsToUsersService.save(shipsToUsers);
        return ServerResponse.success("添加成功", result);
    }

    @PutMapping("/editShip/id/{id}")
    public ServerResponse editShip(@PathVariable("id") int id, @Valid ShipForm shipForm, BindingResult bindingResult) {
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

    @DeleteMapping("/deleteShip/id/{id}")
    public ServerResponse deleteShip(@PathVariable("id") int id, HttpSession session,
                                     @RequestParam(value = "userId", required = false, defaultValue = "0") int userId) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
//        User user = userService.findById(userId);
//        if (user == null) {
//            return ServerResponse.failByMsg("该用户不存在");
//        }
        Ships ship = shipsService.findById(id);
        if (ship == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
//        ShipsToUsers shipsToUsers = shipsToUsersService.findByUserIdAndShipId(userId, id);
        List<ShipsToUsers> shipsToUsersList = shipsToUsersService.findByShipId(id);
        try {
            if (!shipsToUsersList.isEmpty()) {
                shipsToUsersList.forEach(e -> shipsToUsersService.delete(e));
            }
//            shipsToUsersService.delete(shipsToUsers);
            shipsService.delete(ship);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            return ServerResponse.failByMsg("删除失败");
        }
    }
}
