package com.poloniex.futures.rest.req;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AddMarginRequest {

    private String symbol;
    private BigDecimal margin;
    private String bizNo;
}
