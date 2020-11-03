package com.poloniex.futures.model.trade;

import lombok.Data;

@Data
public class OrderDetail {

    private String id;
    private String symbol;
    private String type;
    private String side;
    private String price;
    private Long size;
    private String value;
    private String filledValue;
    private Long filledSize;
    private String stp;
    private String stop;
    private String stopPriceTYpe;
    private Boolean stopTriggered;
    private String stopPrice;
    private String timeInForce;
    private Boolean postOnly;
    private Boolean hidden;
    private Boolean iceberg;
    private Integer visibleSize;
    private String leverage;
    private Boolean reduceOnly;
    private Boolean closeOrder;
    private Boolean forceHold;
    private String clientOid;
    private String remark;
    private Boolean isActive;
    private Boolean cancelExist;
    private String settleCurrency;
    private String status;
    private Long createdAt;
    private Long updatedAt;
    private Long orderTime;
}
