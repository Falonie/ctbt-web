package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.Role;
import com.ctbt.ctbtweb.entity.RoleToUser;
import com.ctbt.ctbtweb.entity.User;
import com.ctbt.ctbtweb.forms.RoleForm;
import com.ctbt.ctbtweb.service.RoleService;
import com.ctbt.ctbtweb.service.RoleToUserService;
import com.ctbt.ctbtweb.service.UserService;
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
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleToUserService roleToUserService;
    @Resource
    private UserService userService;

    /**
     * @return 返回所有角色
     */
    @GetMapping("/roleList")
    public ServerResponse roleList() {
        List<Role> roleList = roleService.findAll();
        return ServerResponse.success(roleList);
    }

    @GetMapping("/id/{id}")
    public ServerResponse findRole(@PathVariable("id") int id) {
        Role role = roleService.findOne(id);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        return ServerResponse.success(role);
    }

    @PostMapping("/addRole")
    public ServerResponse addRole(@Valid RoleForm roleForm, BindingResult bindingResult) {
        Role role = new Role();
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(roleForm, role);
        Role result = roleService.save(role);
        return ServerResponse.success("角色创建成功", result);
    }

    @PutMapping("/editRole/id/{id}")
    public ServerResponse editRole(@PathVariable("id") int id, @Valid RoleForm roleForm, BindingResult bindingResult) {
        Role role = roleService.findOne(id);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        if (bindingResult.hasErrors()) {
            return ServerResponse.failByMsg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        BeanUtils.copyProperties(roleForm, role);
        Role result = roleService.save(role);
        return ServerResponse.success("角色修改成功", result);
    }

    @DeleteMapping("/deleteRole/id/{id}")
    public ServerResponse deleteRole(@PathVariable("id") int id) {
        Role role = roleService.findOne(id);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        try {
            roleService.delete(role);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.failByMsg("删除失败");
        }
    }

    /**
     * @param roleId 角色ID
     * @return 返回绑定该角色的用户
     */
    @GetMapping("/roleToUserList/roleId/{roleId}")
    public ServerResponse roleToUserList(@PathVariable("roleId") int roleId) {
        Role role = roleService.findOne(roleId);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        List<RoleToUser> roleToUserList = roleToUserService.findAllByRoleId(3);
        List<User> userList = roleToUserList.stream().map(e -> userService.findById(e.getUserId())).collect(Collectors.toList());
        return ServerResponse.success(userList);
    }

    /**
     * @param roleId 角色ID
     * @param page
     * @param size
     * @return 返回未绑定到该角色的用户
     */
    @GetMapping("/unbindedRoleToUserList/roleId/{roleId}")
    public ServerResponse unbindedRoleToUserList(@PathVariable("roleId") int roleId,
                                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Role role = roleService.findOne(roleId);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        PageRequest request = PageRequest.of(page - 1, 10);
        Page<User> userPage = userService.findAllByTypeNotInRoleId(roleId, request);
        return ServerResponse.success(userPage.getContent());
    }

    /**
     * @param roleId 角色ID
     * @param userId 用户ID
     * @return 绑定该角色与该用户的关联关系
     */
    @PostMapping("/bindRoleToUser/roleId/{roleId}")
    public ServerResponse bindRoleToUser(@PathVariable("roleId") int roleId, @RequestParam("userId") int userId) {
        Role role = roleService.findOne(roleId);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        RoleToUser roleToUser2 = roleToUserService.findByUserIdAndRoleId(userId, roleId);
        if (roleToUser2 != null) {
            return ServerResponse.failByMsg("该用户已绑定该角色");
        }
        RoleToUser roleToUser = new RoleToUser(userId, roleId);
        RoleToUser result = roleToUserService.save(roleToUser);
        return ServerResponse.success("绑定成功", result);
    }

    /**
     * @param roleId 角色ID
     * @param userId 用户ID
     * @return 删除该角色与该用户的关联关系
     */
    @DeleteMapping("/unbindRoleToUser/roleId/{roleId}")
    public ServerResponse unbindRoleToUser(@PathVariable("roleId") int roleId, @RequestParam("userId") int userId) {
        Role role = roleService.findOne(roleId);
        if (role == null) {
            return ServerResponse.failByMsg("该角色不存在");
        }
        RoleToUser roleToUser = roleToUserService.findByUserIdAndRoleId(userId, roleId);
        if (roleToUser == null) {
            return ServerResponse.failByMsg("该用户未绑定该角色");
        }
        try {
            roleToUserService.delete(roleToUser);
            return ServerResponse.successByMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.failByMsg("删除失败");
        }
    }
}
