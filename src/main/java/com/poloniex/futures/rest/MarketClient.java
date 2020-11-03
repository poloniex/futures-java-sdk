package com.poloniex.futures.rest;

import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;

import java.util.List;

public interface MarketClient {

    List<ContractResponse> getOpenContractList();

    ContractResponse getContractInfo(ContractInfoRequest request);

    MarketTickerResponse getRealTimeTicker(MarketTickerRequest request);

    MarketTicker24hrResponse getTicker24hr(MarketTicker24hrRequest request);

    OrderBookL2Response getFullOrderBookL2(OrderBookRequest request);

    OrderBookL2Response getFullOrderBookL2Pulling(OrderBookPullingRequest request);

    OrderBookL3Response getFullOrderBookL3(OrderBookRequest request);

    List<TradeHistoryResponse> getTradeHistory(TradeHistoryRequest request);

    InterestRateResponse getInterestRateList(InterestRateRequest request);

    IndexResponse getIndexList(IndexRequest request);

    CurrentMarkPriceResponse getCurrentMarkPrice(CurrentMarkPriceRequest request);

    PremiumIndexResponse getPremiumIndex(PremiumIndexRequest request);

    CurrentFundingRateResponse getCurrentFundingRate(CurrentFundingRateRequest request);

    KlineResponse getKline(KlineRequest request);

}
