package com.poloniex.futures.model.position;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundingHistory {

    private Long id;
    private String symbol;
    private long timePoint;
    private BigDecimal fundingRate;
    private BigDecimal markPrice;
    private Long positionQty;
    private BigDecimal positionCost;
    private BigDecimal funding;
    private String settleCurrency;

}
