package com.poloniex.futures.rest.resp;


import lombok.Data;

import java.io.Serializable;

@Data
public class TradeOrderMaxLimitResponse implements Serializable {

    private String symbol;

    private int maxCount;
}
