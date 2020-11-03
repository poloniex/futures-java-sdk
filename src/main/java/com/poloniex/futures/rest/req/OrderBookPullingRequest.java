package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderBookPullingRequest {

    private String symbol;
    private Long start;
    private Long end;

}
