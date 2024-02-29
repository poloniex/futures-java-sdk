package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.AutoDepositMarginRequest;
import com.poloniex.futures.rest.req.FundingHistoryRequest;
import com.poloniex.futures.rest.req.PositionDetailsRequest;
import com.poloniex.futures.rest.req.QueryPosLeverageV3Request;
import com.poloniex.futures.rest.req.UpdateMarginV3Request;
import com.poloniex.futures.rest.resp.FundingHistoryResponse;
import com.poloniex.futures.rest.resp.PositionDetailsResponse;
import java.util.List;

public interface PositionV3Client {

    PositionDetailsResponse getPositionDetails(PositionDetailsRequest request);

    List<PositionDetailsResponse> getPositionList();

    Boolean autoDepositMargin(AutoDepositMarginRequest request);

    void updateMargin(UpdateMarginV3Request request);

    void queryPosLeverage(QueryPosLeverageV3Request request);

    FundingHistoryResponse getFundingHistory(FundingHistoryRequest request);

}
