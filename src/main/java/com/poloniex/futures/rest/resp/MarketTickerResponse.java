/*
 * Copyright 2019 Mek Global Limited
 */

package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class MarketTickerResponse {

    private Long sequence;

    private String symbol;

    private String side;

    private Long size;

    private BigDecimal price;

    private Long bestBidSize;

    private BigDecimal bestBidPrice;

    private Long bestAskSize;

    private BigDecimal bestAskPrice;

    private String tradeId;

    private Long ts;

}
