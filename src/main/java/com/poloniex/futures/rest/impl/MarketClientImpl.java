package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.rest.MarketClient;
import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.utils.InputChecker;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class MarketClientImpl implements MarketClient {

    private static final Logger log = LoggerFactory.getLogger(MarketClientImpl.class);

    private Options options;
    private PoloRestConnection restConnection;

    public MarketClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_OPEN_CONTRACT_PATH = "/api/v1/contracts/active";
    public static final String REST_CONTRACT_INFO_PATH = "/api/v1/contracts/$symbol$";
    public static final String REST_REALTIME_TICKER_PATH = "/api/v1/ticker";
    public static final String REST_24HR_TICKER_PATH = "/api/v1/ticker/24hr/$symbol$";
    public static final String REST_ORDERBOOK_L2_PATH = "/api/v1/level2/snapshot";
    public static final String REST_ORDERBOOK_L2_PULL_PATH = "/api/v1/level2/message/query";
    public static final String REST_ORDERBOOK_L3_PATH = "/api/v2/level3/snapshot";
    public static final String REST_TRADE_HISTORY_PATH = "/api/v1/trade/history";
    public static final String REST_INTEREST_RATE_PATH = "/api/v1/interest/query";
    public static final String REST_INDEX_PATH = "/api/v1/index/query";
    public static final String REST_CURRENT_MARK_PRICE_PATH = "/api/v1/mark-price/$symbol$/current";
    public static final String REST_PREMIUM_INDEX_PATH = "/api/v1/premium/query";
    public static final String REST_CURRENT_FUNDING_RATE_PATH = "/api/v1/funding-rate/$symbol$/current";
    public static final String REST_KLINE_PATH = "/api/v1/kline/query";



    public List<ContractResponse> getOpenContractList() {
        JSONObject result = restConnection.executeGet(REST_OPEN_CONTRACT_PATH, UrlParamsBuilder.build());
        return JSONUtils.toList(result.getJSONArray("data"), ContractResponse.class);
    }

    public ContractResponse getContractInfo(ContractInfoRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        String url = REST_CONTRACT_INFO_PATH.replace("$symbol$", request.getSymbol());
        JSONObject result = restConnection.executeGet(url, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), ContractResponse.class);
    }

    public MarketTickerResponse getRealTimeTicker(MarketTickerRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeGet(REST_REALTIME_TICKER_PATH, UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), MarketTickerResponse.class);
    }

    @Override
    public MarketTicker24hrResponse getTicker24hr(MarketTicker24hrRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        String url = REST_24HR_TICKER_PATH.replace("$symbol$", request.getSymbol());
        JSONObject result = restConnection.executeGet(url,  UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), MarketTicker24hrResponse.class);
    }

    public OrderBookL2Response getFullOrderBookL2(OrderBookRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeGet(REST_ORDERBOOK_L2_PATH, UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), OrderBookL2Response.class);
    }

    public OrderBookL2Response getFullOrderBookL2Pulling(OrderBookPullingRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        InputChecker.checker().shouldNotNull(request.getStart(), "start");
        InputChecker.checker().shouldNotNull(request.getEnd(), "end");
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", request.getSymbol())
                .putToUrl("start", request.getStart())
                .putToUrl("end", request.getEnd());
        JSONObject result = restConnection.executeGet(REST_ORDERBOOK_L2_PULL_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), OrderBookL2Response.class);
    }

    public OrderBookL3Response getFullOrderBookL3(OrderBookRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeGet(REST_ORDERBOOK_L3_PATH, UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toBean(result.getString("data"), OrderBookL3Response.class);
    }

    public List<TradeHistoryResponse> getTradeHistory(TradeHistoryRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        JSONObject result = restConnection.executeGet(REST_TRADE_HISTORY_PATH, UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol()));
        return JSONUtils.toList(result.getJSONArray("data"), TradeHistoryResponse.class);
    }

    public InterestRateResponse getInterestRateList(InterestRateRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        UrlParamsBuilder builder = UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol());
        if (Objects.nonNull(request.getStartAt())) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (Objects.nonNull(request.getEndAt())) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        if (Objects.nonNull(request.getReverse())) {
            builder.putToUrl("reverse", request.getReverse().toString());
        }
        if (Objects.nonNull(request.getOffset())) {
            builder.putToUrl("offset", request.getOffset());
        }
        if (Objects.nonNull(request.getForward())) {
            builder.putToUrl("forward", request.getForward().toString());
        }
        if (Objects.nonNull(request.getMaxCount())) {
            builder.putToUrl("maxCount", request.getMaxCount());
        }
        JSONObject result = restConnection.executeGet(REST_INTEREST_RATE_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), InterestRateResponse.class);
    }

    public IndexResponse getIndexList(IndexRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        UrlParamsBuilder builder = UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol());
        if (Objects.nonNull(request.getStartAt())) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (Objects.nonNull(request.getEndAt())) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        if (Objects.nonNull(request.getReverse())) {
            builder.putToUrl("reverse", request.getReverse().toString());
        }
        if (Objects.nonNull(request.getOffset())) {
            builder.putToUrl("offset", request.getOffset());
        }
        if (Objects.nonNull(request.getForward())) {
            builder.putToUrl("forward", request.getForward().toString());
        }
        if (Objects.nonNull(request.getMaxCount())) {
            builder.putToUrl("maxCount", request.getMaxCount());
        }
        JSONObject result = restConnection.executeGet(REST_INDEX_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), IndexResponse.class);
    }

    public CurrentMarkPriceResponse getCurrentMarkPrice(CurrentMarkPriceRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        String url = REST_CURRENT_MARK_PRICE_PATH.replace("$symbol$", request.getSymbol());
        JSONObject result = restConnection.executeGet(url, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), CurrentMarkPriceResponse.class);
    }

    @Override
    public PremiumIndexResponse getPremiumIndex(PremiumIndexRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        UrlParamsBuilder builder = UrlParamsBuilder.build().putToUrl("symbol", request.getSymbol());
        if (Objects.nonNull(request.getStartAt())) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (Objects.nonNull(request.getEndAt())) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        if (Objects.nonNull(request.getReverse())) {
            builder.putToUrl("reverse", request.getReverse().toString());
        }
        if (Objects.nonNull(request.getOffset())) {
            builder.putToUrl("offset", request.getOffset());
        }
        if (Objects.nonNull(request.getForward())) {
            builder.putToUrl("forward", request.getForward().toString());
        }
        if (Objects.nonNull(request.getMaxCount())) {
            builder.putToUrl("maxCount", request.getMaxCount());
        }
        JSONObject result = restConnection.executeGet(REST_PREMIUM_INDEX_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), PremiumIndexResponse.class);
    }

    public CurrentFundingRateResponse getCurrentFundingRate(CurrentFundingRateRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        String url = REST_CURRENT_FUNDING_RATE_PATH.replace("$symbol$", request.getSymbol());
        JSONObject result = restConnection.executeGet(url, UrlParamsBuilder.build());
        return JSONUtils.toBean(result.getString("data"), CurrentFundingRateResponse.class);
    }

    public KlineResponse getKline(KlineRequest request){
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        InputChecker.checker().shouldNotNull(request.getGranularity(), "granularity");
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", request.getSymbol())
                .putToUrl("granularity",request.getGranularity());
        if (Objects.nonNull(request.getFrom())) {
            builder.putToUrl("from", request.getFrom());
        }
        if (Objects.nonNull(request.getTo())) {
            builder.putToUrl("to", request.getTo());
        }
        JSONObject result = restConnection.executeGet(REST_KLINE_PATH, builder);
        return JSONUtils.toBean(result.toString(), KlineResponse.class);
    }
}
