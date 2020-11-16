package com.poloniex.futures.rest.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class KlineRequest {

    private String symbol;
    private Integer granularity; // 1,5,15,30,60,120,240,480,720,1440,10080
    private Long from;
    private Long to;

}
