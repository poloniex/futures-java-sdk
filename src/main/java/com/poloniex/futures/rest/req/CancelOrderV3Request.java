package com.poloniex.futures.rest.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CancelOrderV3Request {

    private String symbol;
    private String orderId;
    private String clOrdId;
}
