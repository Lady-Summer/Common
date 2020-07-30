package com.summer.connector.http;

import java.io.IOException;

public interface HttpEngine {

    String send(HttpRequest data) throws IOException;

}
