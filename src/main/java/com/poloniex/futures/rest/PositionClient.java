package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.AddMarginRequest;
import com.poloniex.futures.rest.req.FundingHistoryRequest;
import com.poloniex.futures.rest.resp.AddMarginResponse;
import com.poloniex.futures.rest.req.AutoDepositMarginRequest;
import com.poloniex.futures.rest.req.PositionDetailsRequest;
import com.poloniex.futures.rest.resp.FundingHistoryResponse;
import com.poloniex.futures.rest.resp.PositionDetailsResponse;

import java.util.List;

public interface PositionClient {

    PositionDetailsResponse getPositionDetails(PositionDetailsRequest request);

    List<PositionDetailsResponse> getPositionList();

    Boolean autoDepositMargin(AutoDepositMarginRequest request);

    AddMarginResponse addMargin(AddMarginRequest request);

    FundingHistoryResponse getFundingHistory(FundingHistoryRequest request);

}
