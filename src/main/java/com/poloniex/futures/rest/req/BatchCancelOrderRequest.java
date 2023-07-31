package com.poloniex.futures.rest.req;

import lombok.Data;

import java.util.List;

@Data
public class BatchCancelOrderRequest {

    private List<String> orderIdList;
    private List<String> cliOrderIdList;
}
