package com.poloniex.futures.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.rest.AccountClient;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.req.TransferInRequest;
import com.poloniex.futures.rest.req.TransferOutRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.rest.resp.TransactionHistoryResponse;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloRestConnection;
import com.poloniex.futures.rest.resp.TransferInResponse;
import com.poloniex.futures.rest.resp.TransferOutResponse;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.utils.UrlParamsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountClientImpl implements AccountClient {

    private static final Logger log = LoggerFactory.getLogger(AccountClientImpl.class);

    private Options options;
    private PoloRestConnection restConnection;

    public AccountClientImpl(Options options) {
        this.options = options;
        restConnection = new PoloRestConnection(options);
    }

    public static final String REST_ACCOUNT_OVERVIEW_PATH = "/api/v1/account-overview";
    public static final String REST_TRANSACTION_HISTORY_PATH = "/api/v1/transaction-history";

    public static final String REST_TRANSFER_IN_PATH = "/api/v1/futures/transfer-in";

    public static final String REST_TRANSFER_OUT_PATH = "/api/v1/futures/transfer-out";

    @Override
    public AccountOverviewResponse getAccountOverview(AccountOverviewRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getCurrency())) {
            builder.putToUrl("currency", request.getCurrency());
        }
        JSONObject result = restConnection.executeGetWithSignature(REST_ACCOUNT_OVERVIEW_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), AccountOverviewResponse.class);
    }

    @Override
    public TransactionHistoryResponse getTransactionHistory(TransactionHistoryRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        if (StringUtils.isNotBlank(request.getCurrency())) {
            builder.putToUrl("currency", request.getCurrency());
        }
        if (StringUtils.isNotBlank(request.getType())) {
            builder.putToUrl("type", request.getType());
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
        JSONObject result = restConnection.executeGetWithSignature(REST_TRANSACTION_HISTORY_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), TransactionHistoryResponse.class);
    }

    @Override
    public TransferInResponse transferIn(TransferInRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("bizNo", request.getBizNo());
        builder.putToPost("userId", request.getUserId());
        builder.putToPost("currency", request.getCurrency());
        builder.putToPost("amount", request.getAmount());
        JSONObject result = restConnection.executePostWithSignature(REST_TRANSFER_IN_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), TransferInResponse.class);
    }

    @Override
    public TransferOutResponse transferOut(TransferOutRequest request) {
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToPost("bizNo", request.getBizNo());
        builder.putToPost("userId", request.getUserId());
        builder.putToPost("currency", request.getCurrency());
        builder.putToPost("amount", request.getAmount());
        JSONObject result = restConnection.executePostWithSignature(REST_TRANSFER_OUT_PATH, builder);
        return JSONUtils.toBean(result.getString("data"), TransferOutResponse.class);
    }
}
