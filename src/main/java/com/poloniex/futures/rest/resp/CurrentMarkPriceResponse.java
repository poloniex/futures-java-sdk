package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentMarkPriceResponse {

    private String symbol;
    private Long granularity;
    private Long timePoint;
    private BigDecimal value;
    private BigDecimal indexPrice;
}
