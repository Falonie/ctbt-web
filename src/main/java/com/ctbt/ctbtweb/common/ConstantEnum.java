package com.ctbt.ctbtweb.common;

import lombok.Getter;

@Getter
public enum ConstantEnum {
    ADMIN_USER(122, "ADMIN");
    private int userId;
    private String userType;

    ConstantEnum(int userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }
}
