package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.rest.resp.TransactionHistoryResponse;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.rest.impl.AccountClientImpl;
import org.junit.Test;

public class AccountClientTest {

    @Test
    public void test_getAccountOverview() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        AccountClient client = new AccountClientImpl(options);
        AccountOverviewResponse result = client.getAccountOverview(AccountOverviewRequest.builder().currency("USDT").build());
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getTransactionHistory() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        AccountClient client = new AccountClientImpl(options);
        TransactionHistoryResponse result = client.getTransactionHistory(TransactionHistoryRequest.builder().build());
        System.out.println(JSON.toJSONString(result));
    }

}
