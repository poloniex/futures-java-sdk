package com.poloniex.futures.websocket.token;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.rest.impl.AccountClientImpl;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import com.poloniex.futures.websocket.token.WebSocketTokenClient;
import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketTokenClientImpl implements WebSocketTokenClient {

    private static final Logger log = LoggerFactory.getLogger(AccountClientImpl.class);

    private Options options;
    @Getter
    private PoloRestConnection restConnection;

    public WebSocketTokenClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_PUBLIC_TOKEN_PATH = "/api/v1/bullet-public";
    public static final String REST_PRIVATE_TOKEN_PATH = "/api/v1/bullet-private";


    @Override
    public WebSocketTokenResponse getPublicToken() {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        JSONObject result = restConnection.executePost(REST_PUBLIC_TOKEN_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), WebSocketTokenResponse.class);
    }

    @Override
    public WebSocketTokenResponse getPrivateToken() {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        JSONObject result = restConnection.executePostWithSignature(REST_PRIVATE_TOKEN_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), WebSocketTokenResponse.class);
    }
}
