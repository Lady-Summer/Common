package com.summer.com.connector.http;

import lombok.Data;

public enum HttpCode {
    SUCCESS(200, "request success"),
    INTERNAL_ERROR(500, "internal error"),
    SERVER_ERROR(400, "server error");


    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
