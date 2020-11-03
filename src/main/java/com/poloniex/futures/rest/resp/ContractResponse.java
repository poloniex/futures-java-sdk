package com.poloniex.futures.rest.resp;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ContractResponse {


    private String symbol;

    private String rootSymbol;

    private String type;

    private String baseCurrency;

    private String quoteCurrency;

    private Long maxOrderQty;

    private BigDecimal maxPrice;

    private Integer lotSize;

    private Float tickSize;

    private Float multiplier;

    private Float initialMargin;

    private Float maintainMargin;

    private Long maxRiskLimit;

    private Long minRiskLimit;

    private Long riskStep;

    private Float makerFeeRate;

    private Float takerFeeRate;

    private BigDecimal takerFixFee;

    private BigDecimal makerFixFee;

    private Boolean isDeleverage;

    private Boolean isQuanto;

    private Boolean isInverse;

    private String markMethod;

    private String fairMethod;

    private String fundingBaseSymbol;

    private String fundingQuoteSymbol;

    private String fundingRateSymbol;

    private String indexSymbol;

    private BigDecimal volumeOf24h;

    private BigDecimal turnoverOf24h;

    private Long openInterest;

    private BigDecimal maxLeverage;

    private Long nextFundingRateTime;

    private BigDecimal predictedFundingFeeRate;

    private BigDecimal highPriceOf24h;

    private BigDecimal lowPriceOf24h;

    private BigDecimal fundingFeeRate;

    private Long firstOpenDate;

    private BigDecimal markPrice;

    private BigDecimal lastTradePrice;

    private BigDecimal indexPriceTickSize;

    private BigDecimal indexPrice;

    private String settleCurrency;

    private String status;
}
