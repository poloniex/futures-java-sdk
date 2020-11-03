package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TickerChangeEvent {

    private String sequence;

    private String symbol;

    private String side;

    private BigDecimal size;

    private BigDecimal price;

    private BigDecimal bestAskPrice;

    private BigDecimal bestBidPrice;

    private BigDecimal bestAskSize;

    private BigDecimal bestBidSize;

    private String tradeId;

    private Long ts;
}
