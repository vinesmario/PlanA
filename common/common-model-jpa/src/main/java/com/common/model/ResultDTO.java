package com.common.model;

import lombok.Data;

import java.util.Date;

@Data
public class ResultDTO {

    private long timestamp = new Date().getTime();
    private int status;
    private String message;
    private int code;
    private String exception;
    private Object data;

}
