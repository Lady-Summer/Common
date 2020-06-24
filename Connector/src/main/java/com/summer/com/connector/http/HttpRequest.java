package com.summer.com.connector.http;

import lombok.Data;

import java.util.Map;

@Data
public class HttpRequest {

    private String operation;

    private Map<String, String> queryParams;

    private Map<String, String> headers;

    private boolean async;

    private int retry;

    private int timeout;

    private String url;

}
