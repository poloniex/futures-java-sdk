package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MarketTicker24hrRequest {

    private String symbol;
}
