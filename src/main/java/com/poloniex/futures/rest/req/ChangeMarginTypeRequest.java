package com.poloniex.futures.rest.req;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChangeMarginTypeRequest {

    private String symbol;

    private Integer marginType;

}
