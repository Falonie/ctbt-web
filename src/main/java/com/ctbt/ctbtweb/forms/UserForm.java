package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserForm {

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 6, max = 20, message = "用户名长度应为6至20位")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度应为6至20位")
    private String password;

    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;

    private int type;

    private Integer createBy;

    private Date createTime;

    private int userLevel;

}
