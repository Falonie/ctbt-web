package com.ctbt.ctbtweb.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerResponse<T> {
    private int code;
    private String msg;
    private T data;

    private ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> successByMsg(String message) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), data);
    }

    public static <T> ServerResponse<T> success(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> failByMsg(String message) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> fail(T data) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc(), data);
    }
}
