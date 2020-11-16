package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.rest.resp.TransactionHistoryResponse;

public interface AccountClient {

    AccountOverviewResponse getAccountOverview(AccountOverviewRequest request);

    TransactionHistoryResponse getTransactionHistory(TransactionHistoryRequest request);
}
