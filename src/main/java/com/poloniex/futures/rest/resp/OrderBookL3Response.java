package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.util.List;

@Data
public class OrderBookL3Response {

    private Long sequence;

    private String symbol;

    private List<List<String>> asks;

    private List<List<String>> bids;

}
