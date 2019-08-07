package com.ctbt.ctbtweb.forms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProvinceForm {
    @NotEmpty(message = "省份名称不能为空")
    private String name;

    @NotNull(message = "id不能为空")
    private int id;
}
