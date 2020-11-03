package com.poloniex.futures.rest.event;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AnnouncementEvent {

    private String symbol;

    private long fundingTime;

    private BigDecimal fundingRate;

    private long timestamp;

}
