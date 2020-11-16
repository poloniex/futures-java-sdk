package com.poloniex.futures.model.market;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class IndexComponent {

    private String symbol;
    private Long granularity;
    private Long timePoint;
    private BigDecimal value;
    private List<Component> decomposionList;

}
