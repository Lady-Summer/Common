package com.summer.connector.http;

public enum HttpCode {
    SUCCESS(200, "request success"),
    CREATED(201, "Accepted"),
    NO_CONTENT(204, "no content"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    INTERNAL_ERROR(500, "internal error"),
    TIMEOUT(504, "gateway timeout"),
    SERVER_ERROR(503, "server error"),
    RESOURCE_NOT_FOUND(404, "resource not found");

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
