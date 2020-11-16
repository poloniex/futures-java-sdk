package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContractMarketEvent {

    private Long granularity;

    private BigDecimal indexPrice;

    private BigDecimal markPrice;

    private Long timestamp;
}
