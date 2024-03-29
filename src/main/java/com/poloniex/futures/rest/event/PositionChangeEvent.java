package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PositionChangeEvent {

    private BigDecimal realisedGrossPnl;

    private Boolean crossMode;

    private BigDecimal liquidationPrice;

    private BigDecimal posLoss;

    private BigDecimal avgEntryPrice;

    private BigDecimal unrealisedPnl;

    private BigDecimal markPrice;

    private BigDecimal posMargin;

    private BigDecimal riskLimit;

    private BigDecimal unrealisedCost;

    private BigDecimal posComm;

    private BigDecimal posMaint;

    private BigDecimal posCost;

    private BigDecimal maintMarginReq;

    private BigDecimal bankruptPrice;

    private BigDecimal realisedCost;

    private BigDecimal markValue;

    private BigDecimal posInit;

    private BigDecimal realisedPnl;

    private BigDecimal maintMargin;

    private BigDecimal realLeverage;

    private BigDecimal currentCost;

    private Long openingTimestamp;

    private BigDecimal currentQty;

    private BigDecimal delevPercentage;

    private BigDecimal currentComm;

    private BigDecimal realisedGrossCost;

    private Boolean isOpen;

    private BigDecimal posCross;

    private Long currentTimestamp;

    private BigDecimal unrealisedRoePcnt;

    private BigDecimal unrealisedPnlPcnt;

    private Long fundingTime;

    private BigDecimal qty;

    private BigDecimal fundingRate;

    private BigDecimal fundingFee;

    private String settleCurrency;

    private Long ts;
}
