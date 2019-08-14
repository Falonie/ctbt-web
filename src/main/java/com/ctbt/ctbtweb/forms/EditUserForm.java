package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class EditUserForm {

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 6, max = 20, message = "用户名长度应为6至20位")
    private String username;

}
