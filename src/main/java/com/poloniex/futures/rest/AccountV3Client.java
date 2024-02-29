package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.AccountBalanceV3Request;

public interface AccountV3Client {

    void getAccountOverview(AccountBalanceV3Request request);
}
