package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TransactionHistoryRequest {

    private String currency;
    private Long startAt;
    private Long endAt;
    private String type;
    private Long offset;
    private Long maxCount;
}
