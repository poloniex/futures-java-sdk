package com.poloniex.futures.rest.resp;

import java.util.List;
import lombok.Data;

@Data
public class BatchCancelOrdersResponse {

    private List<String> cancelledIds;

    private List<OrderCancelFailVO> cancelFailedOrders;

}
