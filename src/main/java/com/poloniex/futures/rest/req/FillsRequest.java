package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FillsRequest {

    private String orderId;
    private String symbol;
    private String side;
    private String type; //limit, market, limit_stop or market_stop
    private Long startAt;
    private Long endAt;
}
