package com.ctbt.ctbtweb.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CityForm {

    @NotNull(message = "id不能为空")
    private int id;

    @NotEmpty(message = "城市名称不能为空")
    private String name;
//    private int provinceId;

}
