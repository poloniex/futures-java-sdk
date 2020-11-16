package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionStatisticEvent {

    private BigDecimal volume;

    private BigDecimal turnover;

    private BigDecimal lastPrice;

    private BigDecimal priceChgPct;

    private long ts;
}
