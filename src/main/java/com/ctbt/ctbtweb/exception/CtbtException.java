package com.ctbt.ctbtweb.exception;

import com.ctbt.ctbtweb.enums.ResultEnum;

public class CtbtException extends RuntimeException {
    private Integer code;

    public CtbtException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public CtbtException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
