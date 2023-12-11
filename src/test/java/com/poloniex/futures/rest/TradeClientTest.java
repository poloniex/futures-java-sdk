package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.model.trade.OrderDetail;
import com.poloniex.futures.model.trade.TradeDetail;
import com.poloniex.futures.rest.impl.TradeClientImpl;
import com.poloniex.futures.utils.IdGenerator;
import org.junit.Test;

import java.util.List;

public class TradeClientTest {

    @Test
    public void test_placeOrder() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_STG_4)
                .secretKey(Constants.SECRET_KEY_STG_4)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST_NG_STG)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("DOTUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("6.2")
                .size(1)
                .leverage("10")
                .build();
        PlaceOrderResponse result = client.placeOrder(request);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_cancelOrder() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("12")
                .size(10)
                .leverage("10")
                .build();
        PlaceOrderResponse create = client.placeOrder(request);
        CancelOrderRequest request1 = CancelOrderRequest.builder().orderId(create.getOrderId()).build();
        CancelOrdersResponse result = client.cancelOrder(request1);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_cancelOrders() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("12")
                .size(10)
                .leverage("10")
                .build();
        client.placeOrder(request);
        request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("12")
                .size(10)
                .leverage("10")
                .build();
        client.placeOrder(request);
        CancelOrdersRequest request1 = CancelOrdersRequest.builder().symbol("BTCUSDTPERP").build();
        CancelOrdersResponse result = client.cancelOrders(request1);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_cancelStopOrders() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("1211")
                .size(10)
                .leverage("10")
                .stop("down")
                .stopPriceType("TP")
                .stopPrice("123")
                .build();
        client.placeOrder(request);
        request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("1211")
                .size(10)
                .leverage("10")
                .stop("down")
                .stopPriceType("TP")
                .stopPrice("123")
                .build();
        client.placeOrder(request);
        CancelOrdersRequest request1 = CancelOrdersRequest.builder().symbol("BTCUSDTPERP").build();
        CancelOrdersResponse result = client.cancelStopOrders(request1);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     *
     public static void main(String[] args) {
     String method = "GET";
     String url = "/api/v1/orders/123132";

     AntPathMatcher matcher = new AntPathMatcher();
     List<ApiResource> apiResources = new ArrayList<>();
     ApiResource resource = new ApiResource();
     resource.setMethod("GET");
     resource.setUri("/api/v1/orders/*");
     apiResources.add(resource);
     ApiResource resource2 = new ApiResource();
     resource2.setMethod("GET");
     resource2.setUri("/api/v1/account-overview");
     apiResources.add(resource2);
     boolean match = apiResources.stream().anyMatch(r -> {
     return (method.equalsIgnoreCase(r.getMethod()))
     && (r.getUri().equals(url) || matcher.match(r.getUri(), url));
     });
     System.out.println(match);
     }
     */

    @Test
    public void test_getOrderList() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeClient client = new TradeClientImpl(options);
//        PlaceOrderRequest request = PlaceOrderRequest.builder()
//                .symbol("BTCUSDTPERP")
//                .clientOid(IdGenerator.getNextId().toString())
//                .side("buy")
//                .type("limit")
//                .price("1211")
//                .size(10)
//                .leverage("10")
//                .build();
//        client.placeOrder(request);
//        request = PlaceOrderRequest.builder()
//                .symbol("BTCUSDTPERP")
//                .clientOid(IdGenerator.getNextId().toString())
//                .side("buy")
//                .type("limit")
//                .price("1211")
//                .size(10)
//                .leverage("10")
//                .stop("down")
//                .stopPriceType("TP")
//                .stopPrice("123")
//                .build();
//        client.placeOrder(request);
        OrderListRequest request1 = OrderListRequest.builder().symbol("BTCUSDTPERP").status("active").build();
        OrderListResponse result = client.getOrderList(request1);
        System.out.println(JSON.toJSONString(result));
    }


    @Test
    public void test_getStopOrderList() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("1211")
                .size(10)
                .leverage("10")
                .build();
        client.placeOrder(request);
        request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("1211")
                .size(10)
                .leverage("10")
                .stop("down")
                .stopPriceType("TP")
                .stopPrice("123")
                .build();
        client.placeOrder(request);
        StopOrderListRequest request1 = StopOrderListRequest.builder().build();
        StopOrderListResponse result = client.getStopOrderList(request1);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getRecentDoneOrders() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        List<OrderDetail> result = client.getRecentDoneOrders();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getOrderDetail() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        PlaceOrderRequest request = PlaceOrderRequest.builder()
                .symbol("BTCUSDTPERP")
                .clientOid(IdGenerator.getNextId().toString())
                .side("buy")
                .type("limit")
                .price("12")
                .size(10)
                .leverage("10")
                .build();
        PlaceOrderResponse create = client.placeOrder(request);
        OrderDetailRequest request1 = OrderDetailRequest.builder().orderId(create.getOrderId()).build();
        OrderDetail result = client.getOrderDetail(request1);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getFills() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        FillsRequest request = FillsRequest.builder().build();
        FillsResponse result = client.getFills(request);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getRecentFills() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        List<TradeDetail> result = client.getRecentFills();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_openOrderStatistics() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        OrderStatisticsRequest request = OrderStatisticsRequest.builder().symbol("BTCUSDTPERP").build();
        OrderStatisticsResponse result = client.openOrderStatistics(request);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getMaxRisiLimit() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        TradeClient client = new TradeClientImpl(options);
        MaxRiskLimitRequest request = MaxRiskLimitRequest.builder().symbol("aaa").build();
        client.getMaxRiskLimit(request);
//        OrderStatisticsResponse result = client.openOrderStatistics(request);
//        System.out.println(JSON.toJSONString(result));
    }
}
