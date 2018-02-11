package com.model.web;

import lombok.Data;

import java.time.Instant;

@Data
public class HttpResponseDto<T> {

    private Instant timestamp = Instant.now();
    private int status;
    private String message;
    private int code;
    private String exception;
    private T data;

    public HttpResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpResponseDto(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpResponseDto(int status, String message, int code, String exception, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.code = code;
        this.exception = exception;
    }

}
