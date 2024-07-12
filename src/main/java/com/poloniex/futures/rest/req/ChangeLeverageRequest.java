package com.poloniex.futures.rest.req;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChangeLeverageRequest {

    private String symbol;

    private Integer lever;

}
