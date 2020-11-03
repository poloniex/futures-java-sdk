package com.poloniex.futures.model.position;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundingHistory {

    /**
     * id
     */
    private Long id;

    /**
     * 合约symbol
     */
    private String symbol;

    /**
     * 费用时间
     */
    private long timePoint;

    /**
     * 资金费率
     */
    private BigDecimal fundingRate;

    /**
     * 标记价格
     */
    private BigDecimal markPrice;

    /**
     * 实际结算的仓位数
     */
    private Long positionQty;

    /**
     * 实际结算的仓位价值
     */
    private BigDecimal positionCost;

    /**
     * 实际结算的费用
     */
    private BigDecimal funding;

    /**
     * 结算币种
     */
    private String settleCurrency;


}
