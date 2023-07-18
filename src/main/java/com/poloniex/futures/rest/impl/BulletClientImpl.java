package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulletClientImpl {
    private static final Logger log = LoggerFactory.getLogger(AccountClientImpl.class);

    private Options options;
    private PoloRestConnection restConnection;

    public BulletClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public String publicToken(UrlParamsBuilder builder) {
//        if (StringUtils.isNotBlank(request.getCurrency())) {
//            builder.putToUrl("currency", request.getCurrency());
//        }
//        JSONObject result = restConnection.executePostWithSignature("/api/v1/bullet-public",builder);
        JSONObject result = restConnection.executeGetWithSignature("/api/v1/bullet-public",builder);
        return result.toJSONString();
    }

    public String privateToken() {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("protocol","socket.io");
        builder.putToPost("source","mac");
        builder.putToPost("encrypt","true");
        builder.putToPost("front","api");
        JSONObject result = restConnection.executeGetWithSignature("/api/v1/bullet-private",builder);
        return result.toJSONString();
    }

}
