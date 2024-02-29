package com.poloniex.futures.rest.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PlaceOrderV3Request {

    private String symbol;
    private String side;// buy or sell
    private String type;//limit or market
    private String clOrdId;
    private String timeInForce;//GTC, IOC
    private String px;
    private String sz;//lots
    private Boolean reduceOnly;
    private String posSide;
    //    private String leverage;
    //    private String remark;
    private String tpTrgPxType;// last index mark
    private String tpTrgPx;//TP or IP or MP
    private String tpPx;//TP or IP or MP
    private String slTrgPxType;// last index mark
    private String slTrgPx;//TP or IP or MP
    private String slPx;//TP or IP or MP
//    private String stopPrice;
//    private Boolean forceHold;
//    private Boolean postOnly;
//    private Boolean hidden;
//    private Boolean iceberg;
//    private Integer visibleSize;
}
