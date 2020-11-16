package com.poloniex.futures.ws;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.websocket.token.WebSocketTokenClient;
import com.poloniex.futures.websocket.token.WebSocketTokenClientImpl;
import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;
import org.junit.Test;

public class WebSocketTokenClientTest {


    @Test
    public void test_getPublicToken() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        WebSocketTokenClient client = new WebSocketTokenClientImpl(options);
        WebSocketTokenResponse result = client.getPublicToken();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getPrivateToken() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        WebSocketTokenClient client = new WebSocketTokenClientImpl(options);
        WebSocketTokenResponse result = client.getPrivateToken();
        System.out.println(JSON.toJSONString(result));
    }
}
