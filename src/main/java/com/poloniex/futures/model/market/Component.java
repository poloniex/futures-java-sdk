package com.poloniex.futures.model.market;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Component {

    private String exchange;
    private BigDecimal price;
    private BigDecimal weight;

}
