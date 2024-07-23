package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.model.trade.OrderDetail;
import com.poloniex.futures.model.trade.TradeDetail;
import com.poloniex.futures.rest.TradeV3Client;
import com.poloniex.futures.rest.req.BatchCancelOrdersV3Request;
import com.poloniex.futures.rest.req.CancelOrderV3Request;
import com.poloniex.futures.rest.req.CancelOrdersRequest;
import com.poloniex.futures.rest.req.CancelOrdersV3Request;
import com.poloniex.futures.rest.req.ClosePositionV3Request;
import com.poloniex.futures.rest.req.FillsRequest;
import com.poloniex.futures.rest.req.MaxRiskLimitRequest;
import com.poloniex.futures.rest.req.OrderDetailRequest;
import com.poloniex.futures.rest.req.OrderListRequest;
import com.poloniex.futures.rest.req.OrderStatisticsRequest;
import com.poloniex.futures.rest.req.PlaceOrderV3Request;
import com.poloniex.futures.rest.req.QueryOrderOpenV3Request;
import com.poloniex.futures.rest.req.QueryPosLeverageV3Request;
import com.poloniex.futures.rest.req.StopOrderListRequest;
import com.poloniex.futures.rest.resp.CancelOrdersResponse;
import com.poloniex.futures.rest.resp.FillsResponse;
import com.poloniex.futures.rest.resp.OrderListResponse;
import com.poloniex.futures.rest.resp.OrderStatisticsResponse;
import com.poloniex.futures.rest.resp.StopOrderListResponse;
import com.poloniex.futures.utils.InputChecker;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TradeV3ClientImpl implements TradeV3Client {

    private static final Logger log = LoggerFactory.getLogger(TradeV3ClientImpl.class);

    private Options options;

    private PoloRestConnection restConnection;

    public TradeV3ClientImpl(Options options) {
        this.options = options;
        this.restConnection = new PoloRestConnection(options);
    }

    public static final String REST_CREATE_ORDER_PATH = "/api/v3/trade/order";

    public static final String REST_QUERY_ORDER_OPEN_PATH = "/api/v3/trade/order/opens";

    public static final String REST_CLOSE_POSITION_PATH = "/api/v3/trade/position";
    public static final String REST_CANCEL_ORDER_PATH = "/api/v3/trade/order";
    public static final String REST_CANCEL_ORDERS_PATH = "/api/v3/trade/orders";

    public static final String REST_QUERY_LEVERAGE_PATH = "/api/v3/position/leverage";

    public static final String REST_BATCH_CANCEL_ORDERS_PATH = "/api/v3/trade/batchOrders";
    public static final String REST_CANCEL_STOP_ORDERS_PATH = "/api/v1/stopOrders";
    public static final String REST_ORDER_LIST_PATH = "/api/v1/orders";
    public static final String REST_STOP_ORDER_LIST_PATH = "/api/v1/stopOrders";
    public static final String REST_RECENT_DONE_ORDERS_PATH = "/api/v1/recentDoneOrders";
    public static final String REST_ORDER_DETAIL_PATH = "/api/v1/orders/$orderId$";

    public static final String REST_FILLS_PATH = "/api/v1/fills";
    public static final String REST_RECENT_FILLS_PATH = "/api/v1/recentFills";
    public static final String REST_OPEN_ORDER_STATISTICS_PATH = "/api/v1/openOrderStatistics";

    public static final String REST_MAX_RISK_LIMIT = "/api/v1/maxRiskLimit";
    public static final String QUERY_MARGIN_TYPE = "/api/v1/marginType/query";
    public static final String CHANGE_MARGIN_TYPE = "/api/v1/marginType/change";


    @Override
    public void placeOrder(PlaceOrderV3Request request) {
//        InputChecker.checker().shouldNotNull(request.getClientOid(), "clientOid");
//        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
//        InputChecker.checker().shouldNotNull(request.getType(), "type");
//        InputChecker.checker().shouldNotNull(request.getSide(), "side");
//        InputChecker.checker().shouldNotNull(request.getSize(), "size");
//        InputChecker.checker().shouldNotNull(request.getLeverage(), "leverage");
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("symbol", request.getSymbol());
        builder.putToPost("side", request.getSide());
        builder.putToPost("type", request.getType());
        builder.putToPost("clOrdId", request.getClOrdId());
        builder.putToPost("timeInForce", request.getTimeInForce());
        builder.putToPost("px", request.getPx());
        builder.putToPost("sz", request.getSz());
        if (request.getReduceOnly() != null) {
            builder.putToPost("reduceOnly", request.getReduceOnly().toString());
        }
//        builder.putToPost("clientOid", request.getClientOid()).putToPost("symbol", request.getSymbol());
//        builder.putToPost("type", request.getType()).putToPost("side", request.getSide());
//        builder.putToPost("size", request.getSize()).putToPost("leverage", request.getLeverage());
//        if (StringUtils.isNotBlank(request.getStop())) {
//            builder.putToPost("stop", request.getStop());
//        }
//        if (StringUtils.isNotBlank(request.getStopPrice())) {
//            builder.putToPost("stopPrice", request.getStopPrice());
//        }
//        if (StringUtils.isNotBlank(request.getStopPriceType())) {
//            builder.putToPost("stopPriceType", request.getStopPriceType());
//        }
//        if (request.getReduceOnly() != null) {
//            builder.putToPost("reduceOnly", request.getReduceOnly().toString());
//        }
//        if (request.getCloseOrder() != null) {
//            builder.putToPost("closeOrder", request.getCloseOrder().toString());
//        }
//        if (request.getForceHold() != null) {
//            builder.putToPost("forceHold", request.getForceHold().toString());
//        }
//        if (StringUtils.isNotBlank(request.getPrice())) {
//            builder.putToPost("price", request.getPrice());
//        }
//        if (StringUtils.isNotBlank(request.getTimeInForce())) {
//            builder.putToPost("timeInForce", request.getTimeInForce());
//        }
//        if (request.getPostOnly() != null) {
//            builder.putToPost("postOnly", request.getPostOnly().toString());
//        }
//        if (request.getHidden() != null) {
//            builder.putToPost("hidden", request.getHidden().toString());
//        }
//        if (request.getIceberg() != null) {
//            builder.putToPost("iceberg", request.getIceberg().toString());
//        }
//        if (request.getVisibleSize() != null) {
//            builder.putToPost("visibleSize", request.getVisibleSize().toString());
//        }
//        if (StringUtils.isNotBlank(request.getRemark())) {
//            builder.putToPost("remark", request.getRemark());
//        }
        JSONObject result = restConnection.executePostWithSignature(REST_CREATE_ORDER_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), PlaceOrderResponse.class);
    }

    @Override
    public void queryOrderOpen(QueryOrderOpenV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        JSONObject result = restConnection.executeGetWithSignature(REST_QUERY_ORDER_OPEN_PATH, builder);
    }

    @Override
    public void closePosition(ClosePositionV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("symbol", request.getSymbol());
        builder.putToPost("ccy", request.getCcy());
        builder.putToPost("mgnMode", request.getMgnMode());
        JSONObject result = restConnection.executePostWithSignature(REST_CLOSE_POSITION_PATH, builder);
    }

    @Override
    public void cancelOrder(CancelOrderV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("symbol", request.getSymbol());
        if (request.getOrderId() != null) {
            builder.putToPost("ordId", request.getOrderId());
        }
        if (request.getOrderId() != null) {
            builder.putToPost("clOrdId", request.getClOrdId());
        }
        JSONObject result = restConnection.executeDeleteWithSignature(REST_CANCEL_ORDER_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), CancelOrdersResponse.class);
        }

    @Override
    public void cancelOrders(CancelOrdersV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("symbol", request.getSymbol());
        if (request.getSide() != null) {
            builder.putToUrl("side", request.getSide());
        }
        JSONObject result = restConnection.executeDeleteWithSignature(REST_CANCEL_ORDERS_PATH,
                builder);
//        return JSONUtils.toBean(result.getString("data"), CancelOrdersResponse.class);
    }

    @Override
    public void batchCancelOrders(BatchCancelOrdersV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("symbol", request.getSymbol());
        if (request.getOrdIds() != null) {
            builder.putToPost("ordIds", request.getOrdIds());
        }
        if (request.getClOrdIds() != null) {
            builder.putToPost("clOrdIds", request.getClOrdIds());
        }
        JSONObject result = restConnection.executeDeleteWithSignature(REST_BATCH_CANCEL_ORDERS_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), BatchCancelOrdersResponse.class);
    }

    @Override
    public void queryPosLeverage(QueryPosLeverageV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("symbol", request.getSymbol());
        JSONObject result = restConnection.executeGetWithSignature(REST_QUERY_LEVERAGE_PATH, builder);
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

    @Override
    public void queryMarginType(String symbol) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(symbol)) {
            builder.putToUrl("symbol", symbol);
        }
        JSONObject result = restConnection.executeGetWithSignature(QUERY_MARGIN_TYPE,
                builder);
        System.out.println(result);
    }

    @Override
    public void changeMarginType(String symbol, Integer marginType) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(symbol)) {
            builder.putToUrl("symbol", symbol);
        }
        if (Objects.nonNull(marginType)) {
            builder.putToUrl("marginType", marginType);
        }
        JSONObject result = restConnection.executePostWithSignature(CHANGE_MARGIN_TYPE,
                builder);
        System.out.println(result);
    }
}
