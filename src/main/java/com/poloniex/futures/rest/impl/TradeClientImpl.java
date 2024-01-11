package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.rest.TradeClient;
import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.model.trade.OrderDetail;
import com.poloniex.futures.model.trade.TradeDetail;
import com.poloniex.futures.utils.InputChecker;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TradeClientImpl implements TradeClient {

    private static final Logger log = LoggerFactory.getLogger(TradeClientImpl.class);

    private Options options;

    private PoloRestConnection restConnection;

    public TradeClientImpl(Options options) {
        this.options = options;
        this.restConnection = new PoloRestConnection(options);
    }

    public static final String REST_CREATE_ORDER_PATH = "/api/v1/orders";
    public static final String REST_CANCEL_ORDER_PATH = "/api/v1/orders/$orderId$";
    public static final String REST_CANCEL_ORDERS_PATH = "/api/v1/orders";

    public static final String REST_BATCH_CANCEL_ORDERS_PATH = "/api/v1/batchOrders";
    public static final String REST_CANCEL_STOP_ORDERS_PATH = "/api/v1/stopOrders";
    public static final String REST_ORDER_LIST_PATH = "/api/v1/orders";
    public static final String REST_STOP_ORDER_LIST_PATH = "/api/v1/stopOrders";
    public static final String REST_RECENT_DONE_ORDERS_PATH = "/api/v1/recentDoneOrders";
    public static final String REST_ORDER_DETAIL_PATH = "/api/v1/orders/$orderId$";

    public static final String REST_FILLS_PATH = "/api/v1/fills";
    public static final String REST_RECENT_FILLS_PATH = "/api/v1/recentFills";
    public static final String REST_OPEN_ORDER_STATISTICS_PATH = "/api/v1/openOrderStatistics";

    public static final String REST_MAX_RISK_LIMIT = "/api/v1/maxRiskLimit";


    @Override
    public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
        InputChecker.checker().shouldNotNull(request.getClientOid(), "clientOid");
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        InputChecker.checker().shouldNotNull(request.getType(), "type");
        InputChecker.checker().shouldNotNull(request.getSide(), "side");
        InputChecker.checker().shouldNotNull(request.getSize(), "size");
        InputChecker.checker().shouldNotNull(request.getLeverage(), "leverage");
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("clientOid", request.getClientOid()).putToPost("symbol", request.getSymbol());
        builder.putToPost("type", request.getType()).putToPost("side", request.getSide());
        builder.putToPost("size", request.getSize()).putToPost("leverage", request.getLeverage());
        if (StringUtils.isNotBlank(request.getStop())) {
            builder.putToPost("stop", request.getStop());
        }
        if (StringUtils.isNotBlank(request.getStopPrice())) {
            builder.putToPost("stopPrice", request.getStopPrice());
        }
        if (StringUtils.isNotBlank(request.getStopPriceType())) {
            builder.putToPost("stopPriceType", request.getStopPriceType());
        }
        if (request.getReduceOnly() != null) {
            builder.putToPost("reduceOnly", request.getReduceOnly().toString());
        }
        if (request.getCloseOrder() != null) {
            builder.putToPost("closeOrder", request.getCloseOrder().toString());
        }
        if (request.getForceHold() != null) {
            builder.putToPost("forceHold", request.getForceHold().toString());
        }
        if (StringUtils.isNotBlank(request.getPrice())) {
            builder.putToPost("price", request.getPrice());
        }
        if (StringUtils.isNotBlank(request.getTimeInForce())) {
            builder.putToPost("timeInForce", request.getTimeInForce());
        }
        if (request.getPostOnly() != null) {
            builder.putToPost("postOnly", request.getPostOnly().toString());
        }
        if (request.getHidden() != null) {
            builder.putToPost("hidden", request.getHidden().toString());
        }
        if (request.getIceberg() != null) {
            builder.putToPost("iceberg", request.getIceberg().toString());
        }
        if (request.getVisibleSize() != null) {
            builder.putToPost("visibleSize", request.getVisibleSize().toString());
        }
        if (StringUtils.isNotBlank(request.getRemark())) {
            builder.putToPost("remark", request.getRemark());
        }
        JSONObject result = restConnection.executePostWithSignature(REST_CREATE_ORDER_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), PlaceOrderResponse.class);
    }

    @Override
    public CancelOrdersResponse cancelOrder(CancelOrderRequest request) {
        InputChecker.checker().shouldNotNull(request.getOrderId(), "orderId");
        String url = REST_CANCEL_ORDER_PATH.replace("$orderId$", request.getOrderId());
        JSONObject result = restConnection.executeDeleteWithSignature(url, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), CancelOrdersResponse.class);
    }

    @Override
    public CancelOrdersResponse cancelOrders(CancelOrdersRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeDeleteWithSignature(REST_CANCEL_ORDERS_PATH,
                UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), CancelOrdersResponse.class);
    }

    @Override
    public BatchCancelOrdersResponse batchCancelOrders(BatchCancelOrdersRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (request.getOrderIds() != null) {
            builder.putToPost("orderIds", request.getOrderIds());
        }
        if (request.getClientOids() != null) {
            builder.putToPost("clientOids", request.getClientOids());
        }
        JSONObject result = restConnection.executeDeleteWithSignature(REST_BATCH_CANCEL_ORDERS_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), BatchCancelOrdersResponse.class);
    }

    @Override
    public CancelOrdersResponse cancelStopOrders(CancelOrdersRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeDeleteWithSignature(REST_CANCEL_STOP_ORDERS_PATH,
                UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), CancelOrdersResponse.class);
    }

    @Override
    public OrderListResponse getOrderList(OrderListRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        if (StringUtils.isNotBlank(request.getStatus())) {
            builder.putToUrl("status", request.getStatus());
        }
        if (StringUtils.isNotBlank(request.getSide())) {
            builder.putToUrl("side", request.getSide());
        }
        if (StringUtils.isNotBlank(request.getType())) {
            builder.putToUrl("type", request.getType());
        }
        if (request.getStartAt() != null) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (request.getEndAt() != null) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_ORDER_LIST_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), OrderListResponse.class);
    }

    @Override
    public StopOrderListResponse getStopOrderList(StopOrderListRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        if (StringUtils.isNotBlank(request.getSide())) {
            builder.putToUrl("side", request.getSide());
        }
        if (StringUtils.isNotBlank(request.getType())) {
            builder.putToUrl("type", request.getType());
        }
        if (request.getStartAt() != null) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (request.getEndAt() != null) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_STOP_ORDER_LIST_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), StopOrderListResponse.class);
    }

    @Override
    public List<OrderDetail> getRecentDoneOrders() {
        JSONObject result = restConnection.executeGetWithSignature(REST_RECENT_DONE_ORDERS_PATH, UrlParamsBuilder.build());
        return JSONUtils.toList(result.getString("data"), OrderDetail.class);
    }

    @Override
    public OrderDetail getOrderDetail(OrderDetailRequest request) {
        InputChecker.checker().shouldNotNull(request.getOrderId(), "orderId");
        String url = REST_ORDER_DETAIL_PATH.replace("$orderId$", request.getOrderId());
        JSONObject result = restConnection.executeGetWithSignature(url, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), OrderDetail.class);
    }

    @Override
    public FillsResponse getFills(FillsRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        if (StringUtils.isNotBlank(request.getOrderId())) {
            builder.putToUrl("orderId", request.getOrderId());
        }
        if (StringUtils.isNotBlank(request.getSide())) {
            builder.putToUrl("side", request.getSide());
        }
        if (StringUtils.isNotBlank(request.getType())) {
            builder.putToUrl("type", request.getType());
        }
        if (request.getStartAt() != null) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (request.getEndAt() != null) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_FILLS_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), FillsResponse.class);
    }

    @Override
    public List<TradeDetail> getRecentFills() {
        JSONObject result = restConnection.executeGetWithSignature(REST_RECENT_FILLS_PATH, UrlParamsBuilder.build());
        return JSONUtils.toList(result.getString("data"), TradeDetail.class);
    }

    @Override
    public OrderStatisticsResponse openOrderStatistics(OrderStatisticsRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeGetWithSignature(REST_OPEN_ORDER_STATISTICS_PATH,
                UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), OrderStatisticsResponse.class);
    }

    @Override
    public void getMaxRiskLimit(MaxRiskLimitRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_MAX_RISK_LIMIT,
                builder);
        System.out.println(result);
    }
}
