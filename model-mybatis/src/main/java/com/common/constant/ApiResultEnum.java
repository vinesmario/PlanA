package com.common.constant;

public enum ApiResultEnum {

    INVALID_TOKEN(4011,"token不正确"),
    UNAUTHORIZED(4012,"未登录，无权限操作"),
    UNSUPPORTED_GRANT_TYPE(4013,"不支持的授权类型（Grant type)"),
    INVALID_GRANT(4014,"用户名或者密码错误"),
    INVALID_CLIENT(4015,"未被授权的Client"),
    CODE_ERR(4018,"验证码错误"),
    RECORD_NOT_EXIST(5008,"记录不存在"),
    API_GATEWAY_ERROR(5050,"网关发生错误");


    private int code;
    private String message;

    ApiResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    }
