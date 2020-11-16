package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddMarginResponse {

    private String id;
    private String symbol;
    private BigDecimal accountEquity;
    private Boolean autoDeposit;
    private BigDecimal maintMarginReq;
    private Integer riskLimit;
    private BigDecimal realLeverage;
    private Boolean crossMode;
    private BigDecimal delevPercentage;
    private Long openingTimestamp;
    private Long currentTimestamp;
    private BigDecimal currentCost;
    private BigDecimal currentComm;
    private BigDecimal unrealisedCost;
    private BigDecimal realisedGrossCost;
    private BigDecimal realisedCost;
    private Boolean isOpen;
    private BigDecimal markPrice;
    private BigDecimal markValue;
    private BigDecimal posCost;
    private BigDecimal posCross;
    private BigDecimal posInit;
    private BigDecimal posComm;
    private BigDecimal posLoss;
    private BigDecimal posMargin;
    private BigDecimal posMaint;
    private BigDecimal maintMargin;
    private BigDecimal realisedGrossPnl;
    private BigDecimal realisedPnl;
    private BigDecimal unrealisedPnlPcnt;
    private BigDecimal unrealisedRoePcnt;
    private BigDecimal avgEntryPrice;
    private BigDecimal liquidationPrice;
    private BigDecimal bankruptPrice;
    private String settleCurrency;
}
