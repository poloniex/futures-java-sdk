package com.poloniex.futures.rest.event;

import lombok.Data;

@Data
public class OrderChangeEvent {

    private String orderId;
    private String symbol;
    private String type;
    private String status;
    private String matchSize;
    private String matchPrice;
    private String orderType;
    private String side;
    private String price;
    private String size;
    private String remainSize;
    private String filledSize;
    private String canceledSize;
    private String tradeId;
    private String clientOid;
    private Long orderTime;
    private String orderSize;
    private String liquidity;
    private Long ts;

}
