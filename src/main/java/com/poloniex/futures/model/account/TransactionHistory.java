package com.poloniex.futures.model.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionHistory {

    private String currency;
    private String type;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal accountEquity;
    private String status;
    private Long offset;
    private String remark;
    private Long ts;
}
