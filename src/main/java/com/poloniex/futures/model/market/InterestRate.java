package com.poloniex.futures.model.market;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class InterestRate {

    private String symbol;
    private Long granularity;
    private Long timePoint;
    private BigDecimal value;

}
