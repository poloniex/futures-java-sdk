package com.poloniex.futures.rest.v3;

import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.TradeV3Client;
import com.poloniex.futures.rest.impl.TradeV3ClientImpl;
import com.poloniex.futures.rest.req.BatchCancelOrdersV3Request;
import com.poloniex.futures.rest.req.CancelOrderV3Request;
import com.poloniex.futures.rest.req.CancelOrdersV3Request;
import com.poloniex.futures.rest.req.ClosePositionV3Request;
import com.poloniex.futures.rest.req.PlaceOrderV3Request;
import com.poloniex.futures.rest.req.QueryOrderOpenV3Request;
import com.poloniex.futures.rest.req.QueryPosLeverageV3Request;
import java.util.ArrayList;
import java.util.List;
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
                .clOrdId("195325561708937414450")
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

    @Test
    public void test_cancelOrders() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        CancelOrdersV3Request request = CancelOrdersV3Request.builder()
                .symbol("COMBO_USDT_PERP")
//                .ccy("USDT")
                .build();
        client.cancelOrders(request);
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_cancelOrder() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        CancelOrderV3Request request = CancelOrderV3Request.builder()
                .symbol("COMBO_USDT_PERP")
                .orderId("291288235584577536")
//                .ccy("USDT")
                .build();
        client.cancelOrder(request);
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_batchCancelOrders() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);
        List<String> ordIds = new ArrayList<>();
        ordIds.add("291288416363274240");
        ordIds.add("291288659054092288");
//        ordIds.add();
//        ordIds.add();
//        ordIds.add();

        BatchCancelOrdersV3Request request = BatchCancelOrdersV3Request.builder()
                .symbol("COMBO_USDT_PERP")
                .ordIds(ordIds)
                .build();
        client.batchCancelOrders(request);
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_queryPosLeverage() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeV3Client client = new TradeV3ClientImpl(options);

        QueryPosLeverageV3Request request = QueryPosLeverageV3Request.builder()
                .symbol("COMBO_USDT_PERP")
                .build();
        client.queryPosLeverage(request);
//        System.out.println(JSON.toJSONString(result));
    }
}
