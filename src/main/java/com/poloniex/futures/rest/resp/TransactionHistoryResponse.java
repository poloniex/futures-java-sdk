package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.account.TransactionHistory;
import lombok.Data;

import java.util.List;

@Data
public class TransactionHistoryResponse {

    private List<TransactionHistory> dataList;
    private Boolean hasMore;
}
