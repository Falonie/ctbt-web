package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.Constant;
import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Ships;
import com.ctbt.ctbtweb.entity.ShipsToUsers;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.ResetPasswordForm;
import com.ctbt.ctbtweb.forms.EditUserForm;
import com.ctbt.ctbtweb.forms.UserForm;
import com.ctbt.ctbtweb.service.ShipsService;
import com.ctbt.ctbtweb.service.ShipsToUsersService;
import com.ctbt.ctbtweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ShipsToUsersService shipsToUsersService;
    @Resource
    private ShipsService shipsService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ServerResponse register(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return userService.register(userForm);
    }

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestParam(value = "username", defaultValue = "") String username,
                                      @RequestParam(value = "password", defaultValue = "") String password,
                                      HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.getCode() == 200) {
            session.setAttribute(Constant.CURRENT_USER, response.getData());
//            System.out.println("*********" + response.getData() + "*********");
        }
        return response;
    }

    @GetMapping
    public ServerResponse findUser(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
//        User user = userService.findByUsername(username);
        User user = userService.findByIdOrUsername(id, username);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        return ServerResponse.success(user);
    }

    @GetMapping("/list")
    public ServerResponse userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<User> userPage = userService.findAll(request);
        return ServerResponse.success(userPage.getContent());
    }

    @PutMapping("/changePassword")
    public ServerResponse resetPassword(@RequestParam("id") int id, @Valid ResetPasswordForm passwordForm,
                                        BindingResult bindingResult, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return userService.resetPassword(passwordForm.getOldPassword(), passwordForm.getNewPassword(), passwordForm.getConfirmPassword(), user);
    }

    @PutMapping("/editProfile")
    public ServerResponse editProfile(@RequestParam("id") int id, @Valid EditUserForm editUserForm,
                                      BindingResult bindingResult, HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        User user = userService.findById(id);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(editUserForm, user);
        if (userService.findByUsername(editUserForm.getUsername()) != null) {
            return ServerResponse.failByMsg("该用户名已存在");
        }
        User result = userService.save(user);
        return ServerResponse.successByMsg("修改成功");
    }

    public ServerResponse checkValid(String str) {
        User user = userService.findByUsername(str);
        if (user != null) {
            return ServerResponse.failByMsg("该用户名已存在");
        }
        return ServerResponse.successByMsg("校验成功");
    }

    @DeleteMapping("/delete")
    public ServerResponse deleteUser(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        User user = userService.findByIdOrUsername(id, username);
        if (user == null) {
            return ServerResponse.failByMsg("该用户不存在");
        }
        try {
            userService.delete(user);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            return ServerResponse.failByMsg("删除失败");
        }
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
    @GetMapping("/shipList")
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
//        List<Ships> shipsList = shipsToUsersPage.getContent().stream().map(e -> shipsService.findById(e.getShipId())).collect(Collectors.toList());

        List<Integer> shipIdList = shipsToUsersPage.getContent().stream().map(ShipsToUsers::getShipId)
                .collect(Collectors.toList());
        List<Ships> shipsList2 = shipsService.findByIdIn(shipIdList);
        return ServerResponse.success(shipsList2);
    }


    @GetMapping("/unbindShipsListByProductId")
    public ServerResponse unbindShipsListByProductId(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                     @RequestParam(value = "shipId", required = false, defaultValue = "0") int shipId,
                                                     @RequestParam(value = "username", required = false) String username,
                                                     @RequestParam(value = "productId", defaultValue = "") String productId,
                                                     @RequestParam(value = "equipmentId", defaultValue = "") String equipmentId,
                                                     @RequestParam(value = "name", defaultValue = "") String shipName,
                                                     @RequestParam(value = "mmsi", defaultValue = "") String mmsi,
                                                     @RequestParam(value = "userId", required = false, defaultValue = "") int userId,
                                                     @RequestParam(value = "loginUserId", required = false, defaultValue = "") int loginUserId,
                                                     HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        int loginUserId = user.getId();
//        User user = userService.findByIdOrUsername(loginUserId, username);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findByProductIdAndUserIdAndLoginUserId(userId, loginUserId, productId, request);
//        Page<Ships> shipsPage = shipsService.findByProductIdAndEquipmentIdAndNameAndIdAndMmsi(userId, loginUserId, productId, shipName, mmsi, shipId, equipmentId, request);
        List<Ships> shipsList = shipsPage.getContent();
        return ServerResponse.success(shipsList);
    }

    @GetMapping("/unbindShipsListByMmsi")
    public ServerResponse unbindShipsListByMmsi(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                @RequestParam(value = "mmsi", defaultValue = "") String mmsi,
                                                @RequestParam(value = "userId", required = false, defaultValue = "") int userId,
                                                @RequestParam(value = "loginUserId", required = false, defaultValue = "") int loginUserId,
                                                HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        int loginUserId = user.getId();
//        User user = userService.findByIdOrUsername(loginUserId, username);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findByMmsiIdAndUserIdAndLoginUserId(userId, loginUserId, mmsi, request);
        List<Ships> shipsList = shipsPage.getContent();
        return ServerResponse.success(shipsPage);
    }

    @GetMapping("/unbindShipsListByName")
    public ServerResponse unbindShipsListByName(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                @RequestParam(value = "name", defaultValue = "") String shipName,
                                                @RequestParam(value = "userId", required = false, defaultValue = "") int userId,
                                                @RequestParam(value = "loginUserId", required = false, defaultValue = "") int loginUserId,
                                                HttpSession session) {
//        User user = (User) session.getAttribute(Constant.CURRENT_USER);
//        int loginUserId = user.getId();
//        User user = userService.findByIdOrUsername(loginUserId, username);
//        if (user == null) {
//            return ServerResponse.failByMsg("请先登录");
//        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<Ships> shipsPage = shipsService.findByNameAndUserIdAndLoginUserId(userId, loginUserId, shipName, request);
        List<Ships> shipsList = shipsPage.getContent();
        return ServerResponse.success(shipsPage);
    }
}
