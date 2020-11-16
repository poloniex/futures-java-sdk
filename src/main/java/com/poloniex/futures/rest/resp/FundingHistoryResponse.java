package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.position.FundingHistory;
import lombok.Data;

import java.util.List;

@Data
public class FundingHistoryResponse {

    private List<FundingHistory> dataList;
    private Boolean hasMore;

}