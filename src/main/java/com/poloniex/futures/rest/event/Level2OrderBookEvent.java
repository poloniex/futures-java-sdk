package com.poloniex.futures.rest.event;

import lombok.Data;

import java.util.List;

@Data
public class Level2OrderBookEvent {

    /**
     * [price, size] for level2,
     * [order placing nanosecond time, orderId, price, size, nanosecond time at which the order enters the order book] for level3
     */
    private List<List<String>> asks;

    /**
     * [price, size] for level2,
     * [order placing nanosecond time, orderId, price, size, nanosecond time at which the order enters the order book] for level3
     */
    private List<List<String>> bids;

}
