package com.poloniex.futures.rest.resp;

import lombok.Data;

@Data
public class MarketTicker24hrResponse {

    private String symbol;
    private String volume;
    private String priceChgPct;
    private String lowPrice;
    private String highPrice;
    private String turnover;
    private String lastPrice;
    private Long ts;
}
