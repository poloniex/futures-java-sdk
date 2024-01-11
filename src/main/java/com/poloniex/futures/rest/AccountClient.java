package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.req.TransferInRequest;
import com.poloniex.futures.rest.req.TransferOutRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.rest.resp.TransactionHistoryResponse;
import com.poloniex.futures.rest.resp.TransferInResponse;
import com.poloniex.futures.rest.resp.TransferOutResponse;

public interface AccountClient {

    AccountOverviewResponse getAccountOverview(AccountOverviewRequest request);

    void getInternalAccountOverview(String userId);

    TransactionHistoryResponse getTransactionHistory(TransactionHistoryRequest request);

    TransferInResponse transferIn(TransferInRequest request);

    TransferOutResponse transferOut(TransferOutRequest request);
}
