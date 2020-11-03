package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StopOrderLifecycleEvent {

    private String orderId;

    private String symbol;

    private String type;

    private String orderType;

    private String side;

    private Integer size;

    private BigDecimal orderPrice;

    private String stop;

    private BigDecimal stopPrice;

    private String stopPriceType;

    private Boolean triggerSuccess;

    private String error;

    private Long createdAt;

    private Long ts;
}
