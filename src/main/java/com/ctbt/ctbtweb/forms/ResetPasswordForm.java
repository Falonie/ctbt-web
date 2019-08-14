package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ResetPasswordForm {
    @NotEmpty(message = "旧密码不能为空")
    private String oldPassword;

    @NotEmpty(message = "新密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度应为6至20位")
    private String newPassword;

    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;
}
