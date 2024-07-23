package com.poloniex.futures.rest.req;


import java.util.List;
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
public class BatchCancelOrdersV3Request {

    private String symbol;

    private List<String> ordIds;

    private List<String> clOrdIds;
}
