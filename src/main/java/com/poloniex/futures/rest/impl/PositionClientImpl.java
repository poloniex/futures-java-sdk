package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.rest.PositionClient;
import com.poloniex.futures.rest.req.AddMarginRequest;
import com.poloniex.futures.rest.req.AutoDepositMarginRequest;
import com.poloniex.futures.rest.req.FundingHistoryRequest;
import com.poloniex.futures.rest.req.PositionDetailsRequest;
import com.poloniex.futures.rest.resp.AddMarginResponse;
import com.poloniex.futures.rest.resp.FundingHistoryResponse;
import com.poloniex.futures.rest.resp.PositionDetailsResponse;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.utils.InputChecker;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PositionClientImpl implements PositionClient {

    private static final Logger log = LoggerFactory.getLogger(PositionClientImpl.class);

    private Options options;
    private PoloRestConnection restConnection;

    public PositionClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_POSITION_DETAILS_PATH = "/api/v1/position";
    public static final String REST_POSITION_LIST_PATH = "/api/v1/positions";
    public static final String REST_AUTO_DEPOSIT_MARGIN_PATH = "/api/v1/position/margin/auto-deposit-status";
    public static final String REST_ADD_MARGIN_PATH = "/api/v1/position/margin/deposit-margin";
    public static final String REST_FUNDING_HISTORY_PATH = "/api/v1/funding-history";

    @Override
    public PositionDetailsResponse getPositionDetails(PositionDetailsRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_POSITION_DETAILS_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), PositionDetailsResponse.class);
    }

    @Override
    public List<PositionDetailsResponse> getPositionList() {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        JSONObject result = restConnection.executeGetWithSignature(REST_POSITION_LIST_PATH, builder);
        return JSONUtils.toList(result.getString("data"), PositionDetailsResponse.class);
    }

    @Override
    public Boolean autoDepositMargin(AutoDepositMarginRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        InputChecker.checker().shouldNotNull(request.getStatus(), "status");
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToPost("symbol", request.getSymbol())
                .putToPost("status", request.getStatus().toString());
        JSONObject result = restConnection.executePostWithSignature(REST_AUTO_DEPOSIT_MARGIN_PATH, builder);
        return result.getBoolean("data");
    }

    @Override
    public AddMarginResponse addMargin(AddMarginRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        InputChecker.checker().shouldNotNull(request.getMargin(), "margin");
        InputChecker.checker().shouldNotNull(request.getBizNo(), "bizNo");
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToPost("symbol", request.getSymbol())
                .putToPost("margin", request.getMargin().toPlainString())
                .putToPost("bizNo", request.getBizNo());
        JSONObject result = restConnection.executePostWithSignature(REST_ADD_MARGIN_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), AddMarginResponse.class);
    }

    @Override
    public FundingHistoryResponse getFundingHistory(FundingHistoryRequest request) {
        InputChecker.checker().shouldNotNull(request.getSymbol(), "symbol");
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getSymbol())) {
            builder.putToUrl("symbol", request.getSymbol());
        }
        if (request.getStartAt() != null) {
            builder.putToUrl("startAt", request.getStartAt());
        }
        if (request.getEndAt() != null) {
            builder.putToUrl("endAt", request.getEndAt());
        }
        if (request.getOffset() != null) {
            builder.putToUrl("offset", request.getOffset());
        }
        if (request.getMaxCount() != null) {
            builder.putToUrl("maxCount", request.getMaxCount());
        }
        if (request.getReverse() != null) {
            builder.putToUrl("reverse", request.getReverse().toString());
        }
        if (request.getForward() != null) {
            builder.putToUrl("forward", request.getForward().toString());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_FUNDING_HISTORY_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), FundingHistoryResponse.class);
    }
}
