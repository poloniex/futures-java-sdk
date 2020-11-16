package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundingRateChangeEvent {

    private Long granularity;

    private BigDecimal fundingRate;

    private Long timestamp;
}
