package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.trade.TradeDetail;
import lombok.Data;

import java.util.List;

@Data
public class FillsResponse {

    private Long currentPage;
    private Long pageSize;
    private Long totalNum;
    private Long totalPage;
    private List<TradeDetail> items;
}
