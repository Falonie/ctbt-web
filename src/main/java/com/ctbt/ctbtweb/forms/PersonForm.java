package com.ctbt.ctbtweb.forms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
//@Data
public class PersonForm {
    @NotEmpty(message = "姓名不能为空")
    private String name;

//    @NotEmpty(message = "人员救援设备ID不能为空")
    private String equipmentId;

    @NotEmpty(message = "个人电话不能为空")
    private String personalPhone;

    @NotEmpty(message = "身份证号不能为空")
    private String idEntityCard;

    @NotEmpty(message = "工作单位不能为空")
    private String company;

    @NotEmpty(message = "工作单位电话不能为空")
    private String companyPhone;

    @NotEmpty(message = "家庭住址不能为空")
    private String homeAddress;

    @NotEmpty(message = "家庭电话不能为空")
    private String homePhone;

    private String emergencyContactPerson;

    private String emergencyContactNumber;

    private String bloodType;

    private String others;
}
