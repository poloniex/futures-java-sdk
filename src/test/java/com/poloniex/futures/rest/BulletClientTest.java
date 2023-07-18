package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.impl.AccountClientImpl;
import com.poloniex.futures.rest.impl.BulletClientImpl;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.junit.Test;

public class BulletClientTest {

    @Test
    public void publicToken() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        UrlParamsBuilder urlParamsBuilder = UrlParamsBuilder.build();
//        urlParamsBuilder.putToPost("a","1");

        BulletClientImpl bulletClient = new BulletClientImpl(options);
        System.out.println(JSON.toJSONString(bulletClient.publicToken(null)));
    }

    @Test
    public void privateToken() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        BulletClientImpl bulletClient = new BulletClientImpl(options);
        System.out.println(JSON.toJSONString(bulletClient.privateToken()));
    }
}
