package com.poloniex.futures.constant;

public class APIConstants {

    // for auth
    public static final String USER_API_SECRET = "PF-API-SECRET";
    public static final String API_HEADER_KEY = "PF-API-KEY";
    public static final String API_HEADER_SIGN = "PF-API-SIGN";
    public static final String API_HEADER_PASSPHRASE = "PF-API-PASSPHRASE";
    public static final String API_HEADER_TIMESTAMP = "PF-API-TIMESTAMP";

    public static final String API_HEADER_NEED_AUTH = "PF-API-NEED-AUTH";

    // for polo
    public static final String POLO_API_HEADER_TIMESTAMP = "signTimestamp";
    public static final String POLO_API_HEADER_KEY = "key";
    public static final String POLO_API_HEADER_SIGNATURE = "signature";
    public static final String SIGNATURE_METHOD_VALUE = "HmacSHA256";

    public static final String REQUEST_BODY = "requestBody";

    //for ws
    public static final String API_TICKER_TOPIC_PREFIX = "/contractMarket/ticker:";
    public static final String API_LEVEL2_TOPIC_PREFIX = "/contractMarket/level2:";
    public static final String API_LEVEL2_DEPTH_5_PREFIX = "/contractMarket/level2Depth5:";
    public static final String API_LEVEL2_DEPTH_50_PREFIX = "/contractMarket/level2Depth50:";
    public static final String API_EXECUTION_TOPIC_PREFIX = "/contractMarket/execution:";
    public static final String API_LEVEL3_TOPIC_PREFIX = "/contractMarket/level3:";
    public static final String API_CONTRACT_TOPIC_PREFIX = "/contract/instrument:";
    public static final String API_ANNOUNCEMENT_TOPIC_PREFIX = "/contract/announcement";
    public static final String API_TRANSACTION_TOPIC_PREFIX = "/contractMarket/snapshot:";

    public static final String API_ORDER_TOPIC_PREFIX = "/contractMarket/tradeOrders";
    public static final String API_LIFECYCLE_TOPIC_PREFIX = "/contractMarket/advancedOrders";
    public static final String API_BALANCE_TOPIC_PREFIX = "/contractAccount/wallet";
    public static final String API_POSITION_TOPIC_PREFIX = "/contract/position:";
}
