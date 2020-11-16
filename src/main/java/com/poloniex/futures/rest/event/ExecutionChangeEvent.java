package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExecutionChangeEvent {

    private String sequence;

    private String symbol;

    private String side;

    private BigDecimal size;

    private BigDecimal price;

    private String takerOrderId;

    private long time;

    private String makerOrderId;

    private String tradeId;

}
