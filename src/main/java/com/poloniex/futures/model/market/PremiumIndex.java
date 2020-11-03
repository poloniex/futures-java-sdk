package com.poloniex.futures.model.market;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PremiumIndex {

    private String symbol;
    private Long granularity;
    private Long timePoint;
    private BigDecimal value;

}
