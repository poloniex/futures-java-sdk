package com.poloniex.futures.rest.resp;

import lombok.Data;

@Data
public class UserRankFeeResponse {

    private String makerFeeRate;
    private String takerFeeRate;
}
