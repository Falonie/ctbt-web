package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EditCityForm {

    @NotEmpty(message = "城市名称不能为空")
    private String name;
//    private int provinceId;

}
