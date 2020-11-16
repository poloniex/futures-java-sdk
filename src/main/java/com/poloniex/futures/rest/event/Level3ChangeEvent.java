package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Level3ChangeEvent {

    private String symbol;

    private Long sequence;

    private String side;

    private Long orderTime;

    private Long size;

    private String orderId;

    private BigDecimal price;

    private String type;

    private String clientOid;

    private Long ts;

}
