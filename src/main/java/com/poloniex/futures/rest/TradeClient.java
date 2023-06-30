package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;
import com.poloniex.futures.model.trade.OrderDetail;
import com.poloniex.futures.model.trade.TradeDetail;

import java.util.List;

public interface TradeClient {

    UserRankFeeResponse queryUserRankFeeRate();

    UserOrderMaxActiveConfigResponse queryUserMaxOrderActiveConfig();


    Integer queryMarginType(QueryMarginTypeRequest request);

    void changeMarginType(ChangeMarginTypeRequest request);


    PlaceOrderResponse placeOrder(PlaceOrderRequest request);

    CancelOrdersResponse cancelOrder(CancelOrderRequest request);

    CancelOrdersResponse cancelOrders(CancelOrdersRequest request);

    CancelOrdersResponse cancelStopOrders(CancelOrdersRequest request);

    OrderListResponse getOrderList(OrderListRequest request);

    StopOrderListResponse getStopOrderList(StopOrderListRequest request);

    List<OrderDetail> getRecentDoneOrders();

    OrderDetail getOrderDetail(OrderDetailRequest request);

    FillsResponse getFills(FillsRequest request);

    List<TradeDetail> getRecentFills();

    OrderStatisticsResponse openOrderStatistics(OrderStatisticsRequest request);


    TradeOrderMaxActiveResponse queryMaxActiveOrders();


    List<TradeOrderMaxLimitResponse> queryMaxRiskLimit(OrderStatisticsRequest request);
}
