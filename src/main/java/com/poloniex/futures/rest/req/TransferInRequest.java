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
public class TransferInRequest {

    private Long bizNo;
    private String userId;
    private String currency;
    private String amount;
}
