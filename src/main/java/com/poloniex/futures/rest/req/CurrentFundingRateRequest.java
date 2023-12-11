package com.poloniex.futures.rest.req;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CurrentFundingRateRequest {

    private String symbol;
    private Long startAt;
    private Long endAt;
    private Long offset;
    private Boolean forward;
    private Integer maxCount;
    private Boolean reverse;

}
