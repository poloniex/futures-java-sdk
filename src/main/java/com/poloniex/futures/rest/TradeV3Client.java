package com.poloniex.futures.rest;

import com.poloniex.futures.model.trade.OrderDetail;
import com.poloniex.futures.model.trade.TradeDetail;
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
import java.util.List;

public interface TradeV3Client {

    void placeOrder(PlaceOrderV3Request request);

    void queryOrderOpen(QueryOrderOpenV3Request request);

    void closePosition(ClosePositionV3Request request);

    void cancelOrder(CancelOrderV3Request request);

    void cancelOrders(CancelOrdersV3Request request);

    void batchCancelOrders(BatchCancelOrdersV3Request request);

    void queryPosLeverage(QueryPosLeverageV3Request request);

    CancelOrdersResponse cancelStopOrders(CancelOrdersRequest request);

    OrderListResponse getOrderList(OrderListRequest request);

    StopOrderListResponse getStopOrderList(StopOrderListRequest request);

    List<OrderDetail> getRecentDoneOrders();

    OrderDetail getOrderDetail(OrderDetailRequest request);

    FillsResponse getFills(FillsRequest request);

    List<TradeDetail> getRecentFills();

    OrderStatisticsResponse openOrderStatistics(OrderStatisticsRequest request);

    void getMaxRiskLimit(MaxRiskLimitRequest request);

    void queryMarginType(String symbol);

    void changeMarginType(String symbol, Integer marginType);
}
