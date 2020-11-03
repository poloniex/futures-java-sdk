package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.trade.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class StopOrderListResponse {

    private Long currentPage;
    private Long pageSize;
    private Long totalNum;
    private Long totalPage;
    private List<OrderDetail> items;
}
