package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.rest.PositionV3Client;
import com.poloniex.futures.rest.req.AutoDepositMarginRequest;
import com.poloniex.futures.rest.req.FundingHistoryRequest;
import com.poloniex.futures.rest.req.PositionDetailsRequest;
import com.poloniex.futures.rest.req.QueryPosLeverageV3Request;
import com.poloniex.futures.rest.req.UpdateMarginV3Request;
import com.poloniex.futures.rest.resp.FundingHistoryResponse;
import com.poloniex.futures.rest.resp.PositionDetailsResponse;
import com.poloniex.futures.utils.InputChecker;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PositionV3ClientImpl implements PositionV3Client {

    private static final Logger log = LoggerFactory.getLogger(PositionV3ClientImpl.class);

    private Options options;
    private PoloRestConnection restConnection;

    public PositionV3ClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_POSITION_DETAILS_PATH = "/api/v1/position";
    public static final String REST_POSITION_LIST_PATH = "/api/v1/positions";
    public static final String REST_AUTO_DEPOSIT_MARGIN_PATH = "/api/v1/position/margin/auto-deposit-status";
    public static final String REST_UPDATE_MARGIN_PATH = "/api/v3/trade/position/margin";
    public static final String REST_FUNDING_HISTORY_PATH = "/api/v1/funding-history";

    public static final String REST_QUERY_LEVERAGE_PATH = "/api/v3/position/leverage";

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

    //done
    @Override
    public void updateMargin(UpdateMarginV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToPost("symbol", request.getSymbol())
                .putToPost("amt", request.getAmt().toPlainString())
                .putToPost("posSide", request.getPosSide());
        JSONObject result = restConnection.executePostWithSignature(REST_UPDATE_MARGIN_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), AddMarginResponse.class);
    }

    @Override
    public void queryPosLeverage(QueryPosLeverageV3Request request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", request.getSymbol())
                ;
        JSONObject result = restConnection.executeGetWithSignature(REST_QUERY_LEVERAGE_PATH, builder);
//        return JSONUtils.toBean(result.getString("data"), AddMarginResponse.class);
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
