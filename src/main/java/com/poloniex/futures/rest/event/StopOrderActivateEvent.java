package com.poloniex.futures.rest.event;

import lombok.Data;

@Data
public class StopOrderActivateEvent {

    private Boolean success;

    private String orderId;

    private String errorCode;

    private long ts;

}
