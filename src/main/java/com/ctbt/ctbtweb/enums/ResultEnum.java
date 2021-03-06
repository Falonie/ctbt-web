package com.ctbt.ctbtweb.enums;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    ORDER_DELETE_SUCCESS(200, "订单删除成功"),
    ORDER_CANCEL_SUCCESS(200, "订单取消成功"),
    SHIPTEAM_NOT_EXIST(10, "船舶编组不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_ERROR(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    PARAMETER_ERROR(1, "参数不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    ORDER_FINISH_SUCCESS(200, "订单已完结"),
    PRODUCT_STATUS_ERROR(23, "商品状态不正确"),
    PRODUCT_STATUS_SUCCESS(200, "商品状态修改成功");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
