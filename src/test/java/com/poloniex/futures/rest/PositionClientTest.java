package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.req.AddMarginRequest;
import com.poloniex.futures.rest.req.AutoDepositMarginRequest;
import com.poloniex.futures.rest.req.FundingHistoryRequest;
import com.poloniex.futures.rest.req.PositionDetailsRequest;
import com.poloniex.futures.rest.resp.AddMarginResponse;
import com.poloniex.futures.rest.resp.FundingHistoryResponse;
import com.poloniex.futures.rest.resp.PositionDetailsResponse;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.rest.impl.PositionClientImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class PositionClientTest {

    @Test
    public void test_getPositionDetails() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        PositionClient client = new PositionClientImpl(options);
        PositionDetailsResponse result = client.getPositionDetails(PositionDetailsRequest.builder().symbol("BTCUSDTPERP").build());
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getPositionList() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_STG_TEST4)
                .secretKey(Constants.SECRET_KEY_STG_TEST4)
                .passphrase(Constants.PASS_PHRASE_STG_TEST4)
                .restHost(Constants.REST_HOST_OLD_STG)
                .build();
        PositionClient client = new PositionClientImpl(options);
        List<PositionDetailsResponse> result = client.getPositionList();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_autoDepositMargin() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        PositionClient client = new PositionClientImpl(options);
        AutoDepositMarginRequest request = AutoDepositMarginRequest.builder().symbol("BTCUSDTPERP").status(true).build();
        Boolean result = client.autoDepositMargin(request);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_addMargin() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        PositionClient client = new PositionClientImpl(options);
        AddMarginRequest request = AddMarginRequest.builder()
                .symbol("BTCUSDTPERP")
                .margin(new BigDecimal("0.001"))
                .bizNo("123abc")
                .build();
        AddMarginResponse result = client.addMargin(request);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getFundingHistory() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        PositionClient client = new PositionClientImpl(options);
        FundingHistoryRequest request = FundingHistoryRequest.builder()
                .symbol("BTCUSDTPERP")
                .maxCount(2)
                .offset(2L)
                .build();
        FundingHistoryResponse result = client.getFundingHistory(request);
        System.out.println(JSON.toJSONString(result));
    }
}
