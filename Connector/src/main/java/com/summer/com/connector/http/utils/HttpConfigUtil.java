package com.summer.com.connector.http.utils;

import com.summer.com.connector.http.HttpRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;

public class HttpConfigUtil {

    public static HttpGet configHttpGet(HttpRequest data) {
        HttpGet httpGet = new HttpGet(data.getUrl());
        setHeaderAndTimeout(data, httpGet);
        return httpGet;
    }

    private static void setHeaderAndTimeout(HttpRequest data, HttpRequestBase httpGet) {
        data.getHeaders().forEach(httpGet::setHeader);
        int timeout = data.getTimeout();
        RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        httpGet.setConfig(config);
    }

    public static HttpDelete configHttpDelete(HttpRequest data) {
        HttpDelete httpDelete = new HttpDelete(data.getUrl());
        setHeaderAndTimeout(data, httpDelete);
        return httpDelete;
    }

    public static HttpPost configHttpPost(HttpRequest data) {
        HttpPost httpPost = new HttpPost(data.getUrl());
        setHeaderAndTimeout(data, httpPost);
        return httpPost;
    }

    public static HttpPatch configHttpPatch(HttpRequest data) {
        HttpPatch httpPatch = new HttpPatch(data.getUrl());
        setHeaderAndTimeout(data, httpPatch);
        return httpPatch;
    }
}
