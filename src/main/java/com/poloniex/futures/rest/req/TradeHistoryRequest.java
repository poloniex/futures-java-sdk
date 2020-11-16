package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TradeHistoryRequest {

    private String symbol;

}
