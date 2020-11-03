package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderListRequest {

    private String status;//active or done
    private String symbol;
    private String side;
    private String type; //limit, market, limit_stop or market_stop
    private Long startAt;
    private Long endAt;
}