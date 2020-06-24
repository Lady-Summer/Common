package com.summer.com.connector.http;

import com.summer.com.connector.http.utils.HttpConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class HttpEngineImpl implements HttpEngine {

    private HttpClient httpClient = HttpClientBuilder.create().build();

    private Logger LOGGER = LoggerFactory.getLogger(HttpEngine.class);


    public String send(HttpRequest data) throws IOException {

        if (StringUtils.equals(data.getOperation(), Constants.GET))
            return handleRequest(HttpConfigUtil.configHttpGet(data));
        else if (StringUtils.equals(data.getOperation(), Constants.DELETE))
            return handleRequest(HttpConfigUtil.configHttpDelete(data));
        else if (StringUtils.equals(data.getOperation(), Constants.PATCH))
            return handleRequest(HttpConfigUtil.configHttpPatch(data));
        else return handleRequest(HttpConfigUtil.configHttpPost(data));

    }

    private String handleRequest(HttpUriRequest httpReq) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream content = null;
        try {
            HttpResponse response = httpClient.execute(httpReq);
            content = response.getEntity().getContent();
            while (content.read() != -1) {
                byte[] buffer = new byte[1024];
                int flag = content.read(buffer);
                for (byte b : buffer) builder.append(b);
                if (flag != -1) break;
            }
            return builder.toString();
        } catch (ClientProtocolException e) {
            LOGGER.debug("Client protocol is incorrect. The casuse is: {}. The message is: {}", e.getCause(), e.getMessage());
        } finally {
            if (null != content) content.close();
        }
        return null;
    }


}
