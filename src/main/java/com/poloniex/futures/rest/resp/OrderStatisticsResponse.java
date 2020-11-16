package com.poloniex.futures.rest.resp;

import lombok.Data;

@Data
public class OrderStatisticsResponse {

    private Long openOrderBuySize;
    private Long openOrderSellSize;
    private String openOrderBuyCost;
    private String openOrderSellCost;
    private String settleCurrency;
}
