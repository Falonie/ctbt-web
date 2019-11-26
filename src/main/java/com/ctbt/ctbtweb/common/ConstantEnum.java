package com.ctbt.ctbtweb.common;

import lombok.Getter;
import lombok.Setter;

public enum ConstantEnum {
    ADMIN_USER(122, "ADMIN");
    private int userId;
    private String userType;

    ConstantEnum(int userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }
}
