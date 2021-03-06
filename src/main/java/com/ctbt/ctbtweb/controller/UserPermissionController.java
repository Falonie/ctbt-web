package com.ctbt.ctbtweb.controller;

import com.ctbt.ctbtweb.common.ServerResponse;
import com.ctbt.ctbtweb.entity.UserRolePermission;
import com.ctbt.ctbtweb.entity.UserRolePermissionId;
import com.ctbt.ctbtweb.service.PermissionService;
import com.ctbt.ctbtweb.service.UserRolePermissionService;
import com.ctbt.ctbtweb.vo.PermissionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissionManagement")
@Slf4j
public class UserPermissionController {
    @Resource
    private UserRolePermissionService userRolePermissionService;
    @Resource
    private PermissionService permissionService;

    /**
     * @param userId         用户ID或角色ID
     * @param permissionType 用户或角色类型
     * @return 该用户的权限
     */
    @GetMapping("/userPermissionsList/permissionType/{permissionType}/userId/{userId}")
    public ServerResponse userPermissionsList(@PathVariable("userId") int userId,
                                              @PathVariable("permissionType") String permissionType) {
//        List<UserRolePermission> userRolePermissionList = userRolePermissionService.
//                findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(userId, permissionType);

/*        List<PermissionVO> permissionList = userRolePermissionService
                .findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(userId, permissionType)
                .stream().map(UserRolePermission -> {
                    PermissionVO permissionVO = new PermissionVO();
                    BeanUtils.copyProperties(permissionService
                            .findByPermId(UserRolePermission.getUserRolePermissionId().getPermId()), permissionVO);
                    return permissionVO;
                })
                .collect(Collectors.toList());*/

        List<Integer> permissionIdList = userRolePermissionService
                .findByUserRolePermissionIdUrIdAndUserRolePermissionIdPermType(userId, permissionType)
                .stream().map(UserRolePermission::getUserRolePermissionId)
                .map(UserRolePermissionId::getPermId)
                .collect(Collectors.toList());

//        List<Permission> permissionList2 = permissionService.findByPermIdIn(permissionIdList);

        List<PermissionVO> permissionVOList = permissionService
                .findByPermIdIn(permissionIdList).stream()
                .map(Permission -> {
                    PermissionVO permissionVO = new PermissionVO();
                    BeanUtils.copyProperties(Permission, permissionVO);
                    return permissionVO;
                })
                .collect(Collectors.toList());
        return ServerResponse.success(permissionVOList);
    }
}
