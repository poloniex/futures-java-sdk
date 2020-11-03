package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AutoDepositMarginRequest {

    private String symbol;
    private Boolean status;
}
