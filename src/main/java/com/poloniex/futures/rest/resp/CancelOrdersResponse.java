package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.util.List;

@Data
public class CancelOrdersResponse {

    private List<String> cancelledOrderIds;
}
