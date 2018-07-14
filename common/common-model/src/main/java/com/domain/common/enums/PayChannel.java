package com.domain.common.enums;

/**
 * 支付渠道
 */
public enum PayChannel {

    CASH(0, "现金支付"),
    WECHAT(1,"微信支付"),
    ALIPAY(2,"支付宝支付"),
    UNIONPAY(10, "银联支付"),

    wechat_app(21, "微信支付"),
    wechat_jsapi(22, "微信公众号（jsapi）支付"),
    wechat_h5(23, "微信H5支付"),
    wechat_native(24, "微信原生支付"),
    alipay_app(31, "支付宝APP支付"),
    alipay_jsapi(32, "支付宝生活号（jsapi）支付"),
    alipay_h5(33, "支付宝H5支付"),
    alipay_native(34, "支付宝原生支付"),
    wallet(99, "钱包余额（合规？）");

    private Integer code;
    private String name;

    PayChannel(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
