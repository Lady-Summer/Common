package com.summer.com.connector.http;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {

    private int retry;

    private int timeout;

    private String uri;

}
