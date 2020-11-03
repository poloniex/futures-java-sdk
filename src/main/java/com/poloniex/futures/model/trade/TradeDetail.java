package com.poloniex.futures.model.trade;

import lombok.Data;

@Data
public class TradeDetail {

    private String symbol;
    private String orderId;
    private String tradeId;
    private String side;
    private String liquidity;
    private String price;
    private Long size;
    private String value;
    private String feeRate;
    private String fixFee;
    private String feeCurrency;
    private String stop;
    private String fee;
    private String orderType;
    private String tradeType;
    private String settleCurrency;
    private Long createdAt;
    private Long tradeTime;
}
