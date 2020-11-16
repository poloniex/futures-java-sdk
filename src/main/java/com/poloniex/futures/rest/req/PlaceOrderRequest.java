package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlaceOrderRequest {

    private String clientOid;
    private String side;// buy or sell
    private String symbol;
    private String type;//limit or market
    private String leverage;
    private String remark;
    private String stop;// down or up
    private String stopPriceType;//TP or IP or MP
    private String stopPrice;
    private Boolean reduceOnly;
    private Boolean closeOrder;
    private Boolean forceHold;
    private String price;
    private Integer size;//lots
    private String timeInForce;//GTC, IOC
    private Boolean postOnly;
    private Boolean hidden;
    private Boolean iceberg;
    private Integer visibleSize;
}
