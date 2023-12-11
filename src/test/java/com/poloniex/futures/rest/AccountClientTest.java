package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.req.TransferInRequest;
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
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        AccountClient client = new AccountClientImpl(options);
        TransactionHistoryResponse result = client.getTransactionHistory(TransactionHistoryRequest.builder()
                        .currency("USDT")
                        .maxCount(100L)
                .build());
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_transferIn() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_STG_INTERNAL)
                .secretKey(Constants.SECRET_KEY_STG_INTERNAL)
                .passphrase(Constants.PASS_PHRASE_STG_INTERNAL)
                .restHost(Constants.REST_HOST_NG_STG)
                .build();
        AccountClient client = new AccountClientImpl(options);
        TransferInRequest request = TransferInRequest.builder()
                .bizNo(System.currentTimeMillis() + "")
                .userId("14247477")
                .amount("100")
                .currency("USDT").build();
        client.transferIn(request);
    }
}
