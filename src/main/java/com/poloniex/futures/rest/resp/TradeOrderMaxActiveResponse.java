package com.poloniex.futures.rest.resp;


import lombok.Data;

import java.io.Serializable;

@Data
public class TradeOrderMaxActiveResponse implements Serializable {

    private long maxStopOrder;
    private long maxOrder;
}
