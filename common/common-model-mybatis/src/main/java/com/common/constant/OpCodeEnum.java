package com.common.constant;

public enum OpCodeEnum {
    LOGIN_REQUEST(0xA100,"登录请求"),PING_REQUEST(0xA101,"心跳请求"),
    PARK_IN_REPORT_REQUEST(0xA110,"进场汇报请求"),
    PARK_OUT_REPORT_REQUEST(0xA111,"出场汇报请求"),
    QUERY_PARK_FEE_REQUEST(0xA212,"查询车辆停车费请求"),
    PARK_FEE_CALCULATION_REQUEST(0xA213,"停车费计算请求"),
    QUERY_PAY_STATUS_REQUEST(0xA114,"支付状态查询请求"),
    PARK_PAY_REPORT_REQUEST(0xA115,"(停车场的)停车收费汇报"),
    PARK_PAY_NOTIFY_REQUEST(0xA216,"(线上)停车支付通知"),
    QUERY_PARK_INFO_REQUEST(0xA217,"查询出口车辆信息"),
    GET_PARK_IMG_REQUEST(0xA218,"请求出入口实时图片"),
    REMOTE_OPEN_REQUEST(0xA219,"远程开闸请求"),

    LOGIN_RESPONSE(0xB100,"登录响应"),
    PING_RESPONSE(0xB101,"心跳响应"),
    PARK_IN_REPORT_RESPONSE(0xB110,"进场汇报响应"),
    PARK_OUT_REPORT_RESPONSE(0xB111,"出场汇报响应"),
    QUERY_PARK_FEE_RESPONSE(0xB212,"查询车辆停车费响应"),
    PARK_FEE_CALCULATION_RESPONSE(0xB213,"停车费计算响应"),
    QUERY_PAY_STATUS_RESPONSE(0xB114,"支付状态查询响应"),
    PARK_PAY_REPORT_RESPONSE(0xB115,"(停车场的)停车收费汇报"),
    PARK_PAY_NOTIFY_RESPONSE(0xB216,"(线上)停车支付通知"),
    QUERY_PARK_INFO_RESPONSE(0xB217,"查询出口车辆信息"),
    GET_PARK_IMG_RESPONSE(0xB218,"响应出入口实时图片"),
    REMOTE_OPEN_RESPONSE(0xB219,"远程开闸响应"),

    MSG_RECEIVE_CONFIRM(0xF001,"消息接收确认"),

    GET_PARKINFO_REQUEST(0xA102,"查询停车场信息请求"),
    GET_PARKINFO_RESPONSE(0xB102,"查询停车场信息响应"),

    PARKING_STATUS_REPORT(0xA103,"停车场状态信息汇报");

    private int code;
    private String val;

    OpCodeEnum(int code, String val){
        this.code=code;
        this.val=val;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

}
