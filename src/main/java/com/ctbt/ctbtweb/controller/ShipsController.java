package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.Constant;
import com.ctbt.ctbtweb.common.ConstantEnum;
import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.*;
import com.ctbt.ctbtweb.forms.ShipForm;
import com.ctbt.ctbtweb.forms.ShipSearchForm;
import com.ctbt.ctbtweb.service.*;
import com.ctbt.ctbtweb.vo.BindShipRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
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
    private AlarmRecordService alarmRecordService;
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
                                  @RequestParam(value = "id", required = false, defaultValue = "0") int userId) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(userId);
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
        if (shipsService.findByProductId(shipForm.getProductId()) != null) {
            return ServerResponse.failByMsg("该产品ID已存在");
        }
        BeanUtils.copyProperties(shipForm, ships);
        Ships result = shipsService.save(ships);

        if (userId != ConstantEnum.ADMIN_USER.getUserId()) {
            ShipsToUsers shipsToUsers2 = new ShipsToUsers(result.getId(), userId);
            shipsToUsersService.save(shipsToUsers2);
        }
        ShipsToUsers shipsToUsers = new ShipsToUsers(result.getId(), ConstantEnum.ADMIN_USER.getUserId());
        shipsToUsersService.save(shipsToUsers);
        return ServerResponse.success("添加成功", result);
    }

    /**
     * 修改船舶信息
     *
     * @param id            船舶ID
     * @param shipForm
     * @param bindingResult
     * @return
     */
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

    /**
     * 删除船舶
     *
     * @param id      船舶ID
     * @param session
     * @param userId
     * @return
     */
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
            List<AlarmRecord> alarmRecordList = alarmRecordService.findByShipId(ship);

            if (!CollectionUtils.isEmpty(alarmRecordList)) {
                alarmRecordList.forEach(alarmRecord -> alarmRecordService.delete(alarmRecord));
/*
                alarmRecordList.forEach(alarmRecord -> {
                    List<AlarmToUser> alarmToUserList = alarmToUserService.findAllByAlarmRecordId(alarmRecord.getAlarmRecordId());
                    if (!CollectionUtils.isEmpty(alarmToUserList)) {
                        alarmToUserList.forEach(alarmToUser -> alarmToUserService.delete(alarmToUser));
                    }
                    alarmRecordService.delete(alarmRecord);
                });
*/
            }

            shipsService.delete(ship);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            return ServerResponse.failByMsg("删除失败");
        }
    }

    /**
     * 添加绑定船舶至指定用户
     *
     * @param shipId 船舶ID
     * @param userId 用户ID
     * @return
     */
    @PostMapping("/addShipToUser")
    public ServerResponse addShipToUser(@RequestParam("shipId") int shipId,
                                        @RequestParam("userId") int userId) {
        Ships ships = shipsService.findById(shipId);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        ShipsToUsers shipsToUsers = new ShipsToUsers(shipId, userId, new Date());
        ShipsToUsers result = shipsToUsersService.save(shipsToUsers);
        return ServerResponse.success("添加成功", result);
    }

/*
    @PostMapping("/bindShipToUser")
    public ServerResponse bindShipToUser(@RequestBody BindShipRequest bindShipRequest,
                                         @RequestParam("userId") int userId) {
        Ships ships = shipsService.findById(shipId);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        ShipsToUsers shipsToUsers = new ShipsToUsers(shipId, userId, new Date());
        ShipsToUsers result = shipsToUsersService.save(shipsToUsers);
        return ServerResponse.success("添加成功", result);
    }
*/

    /**
     * 解绑船舶与用户的关系
     *
     * @param shipId 船舶ID
     * @param userId 用户ID
     * @return
     */
    @DeleteMapping("/unbindShipToUser")
    public ServerResponse deleteShipToUser(@RequestParam("shipId") int shipId,
                                           @RequestParam("userId") int userId) {
        Ships ships = shipsService.findById(shipId);
        if (ships == null) {
            return ServerResponse.failByMsg("该船舶不存在");
        }
        ShipsToUsers shipsToUsers = shipsToUsersService.findByUserIdAndShipId(userId, shipId);
        try {
            shipsToUsersService.delete(shipsToUsers);
            return ServerResponse.successByMsg("解绑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.failByMsg("解绑失败");
        }
    }

    /**
     * @param page   default 1
     * @param size   default 10
     * @param userId 用户ID
     * @return 该用户已绑定的船舶
     */
    @GetMapping("/bindedShips/userId/{userId}")
    public ServerResponse bindedShips(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size,
                                      @PathVariable("userId") int userId) {
        User user = userService.findByIdOrUsername(userId, "username");
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<ShipsToUsers> shipsToUsersPage = shipsToUsersService.findByUserId(user.getId(), request);
//        List<Ships> shipsList = shipsToUsersPage.getContent().stream().map(e -> shipsService.findById(e.getShipId())).collect(Collectors.toList());

        List<Integer> shipIdList = shipsToUsersPage.getContent().stream().map(ShipsToUsers::getShipId)
                .collect(Collectors.toList());
        List<Ships> shipsList2 = shipsService.findByIdIn(shipIdList);
        return ServerResponse.success(shipsList2);
    }

    /**
     * @param productId 产品ID
     * @param userId    用户ID
     * @return 按条件搜索该用户下已绑定的船
     */
    @GetMapping("/bindedShips")
    public ServerResponse searchBindedShipsByProductId(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                       @RequestParam(value = "productId", defaultValue = "") String productId,
                                                       @RequestParam(value = "shipName", defaultValue = "") String shipName,
                                                       @RequestParam(value = "equipmentId", defaultValue = "") String equipmentId,
                                                       @RequestParam(value = "shipId", defaultValue = "", required = false) String shipId,
                                                       @RequestParam("userId") int userId) {
        User user = userService.findByIdOrUsername(userId, "username");
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = null;
        if (!productId.equals("")) {
            shipsPage = shipsService.findBindedShipsByProductId(productId, userId, request);
            return ServerResponse.success(shipsPage.getContent());
        } else if (!shipName.equals("")) {
            shipsPage = shipsService.findBindedShipsByShipName(shipName, userId, request);
            return ServerResponse.success(shipsPage.getContent());
        } else if (!equipmentId.equals("")) {
            shipsPage = shipsService.findBindedShipsByEquipmentId(equipmentId, userId, request);
            return ServerResponse.success(shipsPage.getContent());
        } else if (!shipId.equals("")) {
            int id = Integer.parseInt(shipId);
            Page<ShipsToUsers> shipsToUsersPage = shipsToUsersService.findByUserIdAndShipIdLike(userId, id, request);
//            List<Ships> shipsList = shipsToUsersPage.getContent().stream().map(e -> shipsService.findById(e.getShipId())).collect(Collectors.toList());

            List<Integer> shipIdList = shipsToUsersPage.getContent().stream().map(ShipsToUsers::getShipId)
                    .collect(Collectors.toList());
            List<Ships> shipsList2 = shipsService.findByIdIn(shipIdList);
            return ServerResponse.success(shipsList2);
        }
        return ServerResponse.failByMsg("请选择条件");
    }
}
