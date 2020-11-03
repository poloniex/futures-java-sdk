package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountChangeEvent {

    private BigDecimal orderMargin;

    private BigDecimal availableBalance;

    private BigDecimal withdrawHold;

    private String currency;

    private long timestamp;

}
