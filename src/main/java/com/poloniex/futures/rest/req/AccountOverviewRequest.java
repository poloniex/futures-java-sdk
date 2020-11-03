package com.poloniex.futures.rest.req;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AccountOverviewRequest {

    private String currency;
}
