package com.poloniex.futures.rest.v3;

import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.TradeV3Client;
import com.poloniex.futures.rest.impl.TradeV3ClientImpl;
import com.poloniex.futures.rest.req.ClosePositionV3Request;
import com.poloniex.futures.rest.req.PlaceOrderV3Request;
import com.poloniex.futures.rest.req.QueryOrderOpenV3Request;
import org.junit.Test;

/**
 * @auther zhengxin
 * @date 2024/2/26
 */
public class TradeV3ClientTest {
    @Test
    public void test_placeOrder() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        PlaceOrderV3Request request = PlaceOrderV3Request.builder()
                .symbol("COMBO_USDT_PERP")
                .clOrdId("195325561708937414446")
                .side("buy")
                .type("limit")
                .px("4.8102")
                .sz("1")
                .build();
        client.placeOrder(request);
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_queryOrderOpen() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        QueryOrderOpenV3Request request = QueryOrderOpenV3Request.builder().build();
        client.queryOrderOpen(request);
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_closePosition() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        ClosePositionV3Request request = ClosePositionV3Request.builder()
                .symbol("COMBO_USDT_PERP")
                .mgnMode("CROSS")
                .ccy("USDT").build();
        client.closePosition(request);
//        System.out.println(JSON.toJSONString(result));
    }
}
