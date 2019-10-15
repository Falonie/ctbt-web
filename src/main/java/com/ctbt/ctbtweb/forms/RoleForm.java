package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class RoleForm {
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

    @NotEmpty(message = "角色描述不能为空")
    private String roleDesc;

    @NotEmpty(message = "是否有效不能为空")
    private String validity;
}
