package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountOverviewResponse {

    private BigDecimal accountEquity;
    private BigDecimal availableBalance;
    private BigDecimal frozenFunds;
    private BigDecimal marginBalance;
    private BigDecimal orderMargin;
    private BigDecimal positionMargin;
    private BigDecimal unrealisedPNL;
    private String currency;
}
