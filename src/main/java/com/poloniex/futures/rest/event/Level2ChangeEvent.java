package com.poloniex.futures.rest.event;

import lombok.Data;

@Data
public class Level2ChangeEvent {

    private String symbol;

    private Long sequence;

    /**
     * price,side,size
     */
    private String change;
}
