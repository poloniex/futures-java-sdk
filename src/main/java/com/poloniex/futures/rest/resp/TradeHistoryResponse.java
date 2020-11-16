package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradeHistoryResponse {

    private Long sequence;
    private String tradeId;
    private String takerOrderId;
    private String makerOrderId;
    private BigDecimal price;
    private BigDecimal size;
    private String side;

}