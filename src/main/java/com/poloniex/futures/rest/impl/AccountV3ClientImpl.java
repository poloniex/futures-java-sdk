package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.rest.AccountV3Client;
import com.poloniex.futures.rest.req.AccountBalanceV3Request;
import com.poloniex.futures.utils.UrlParamsBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class AccountV3ClientImpl implements AccountV3Client {

    private Options options;
    private PoloRestConnection restConnection;

    public AccountV3ClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_ACCOUNT_OVERVIEW_PATH = "/api/v3/account/balance";

    @Override
    public void getAccountOverview(AccountBalanceV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getCcy())) {
            builder.putToUrl("ccy", request.getCcy());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_ACCOUNT_OVERVIEW_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), AccountOverviewResponse.class);
    }
}
