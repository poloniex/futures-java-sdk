package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.rest.CommonClient;
import com.poloniex.futures.rest.resp.ServiceStatusResponse;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloiRestConnection;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonClientImpl implements CommonClient {

    private static final Logger log = LoggerFactory.getLogger(MarketClientImpl.class);

    private Options options;
    private PoloiRestConnection restConnection;

    public CommonClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloiRestConnection(options);
    }

    public static final String REST_TIME_PATH = "/api/v1/timestamp";
    public static final String REST_STATUS_PATH = "/api/v1/status";

    @Override
    public Long time() {
        JSONObject result = restConnection.executeGet(REST_TIME_PATH, UrlParamsBuilder.build());
        return result.getLong("data");
    }

    @Override
    public ServiceStatusResponse status() {
        JSONObject result = restConnection.executeGet(REST_STATUS_PATH, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), ServiceStatusResponse.class);
    }
}
