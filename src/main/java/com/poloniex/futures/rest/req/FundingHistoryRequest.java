package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FundingHistoryRequest {

    private String symbol;
    private Long startAt;
    private Long endAt;
    private Boolean reverse;
    private Long offset;
    private Boolean forward;
    private Integer maxCount;
}
