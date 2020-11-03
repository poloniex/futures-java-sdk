package com.poloniex.futures.websocket.impl;

import com.alibaba.fastjson.TypeReference;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.rest.callback.WSCallback;
import com.poloniex.futures.rest.event.*;
import com.poloniex.futures.websocket.PublicWSClient;
import com.poloniex.futures.websocket.listener.PoloWebsocketListener;
import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;
import com.poloniex.futures.websocket.token.WebSocketTokenClient;
import com.poloniex.futures.websocket.token.WebSocketTokenClientImpl;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PublicWSClientImpl extends BaseWebsocketImpl implements PublicWSClient {

    private WebSocketTokenClient tokenClient;

    public PublicWSClientImpl(Options options, PoloWebsocketListener websocketListener) {
        super(options, websocketListener);
        this.tokenClient = new WebSocketTokenClientImpl(options);
    }

    @Override
    public String unsubscribe(String topicPrefix, String... symbols) {
        return super.unsubscribe(topicPrefix + Arrays.stream(symbols).collect(Collectors.joining(",")),
                false, true);
    }

    @Override
    protected WebSocketTokenResponse requestToken() {
        return tokenClient.getPublicToken();
    }

    @Override
    public String onTicker(WSCallback<WSEvent<TickerChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_TICKER_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<TickerChangeEvent>>() {
                    }));
        }
        String topic = APIConstants.API_TICKER_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onLevel2Data(WSCallback<WSEvent<Level2ChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_LEVEL2_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<Level2ChangeEvent>>() {
                    }));
        }
        String topic = APIConstants.API_LEVEL2_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onLevel2Depth5Data(WSCallback<WSEvent<Level2OrderBookEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_LEVEL2_DEPTH_5_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<Level2OrderBookEvent>>() {
                    }));
        }
        String topic = APIConstants.API_LEVEL2_DEPTH_5_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onLevel2Depth50Data(WSCallback<WSEvent<Level2OrderBookEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_LEVEL2_DEPTH_50_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<Level2OrderBookEvent>>() {
                    }));
        }
        String topic = APIConstants.API_LEVEL2_DEPTH_50_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onExecutionData(WSCallback<WSEvent<ExecutionChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_EXECUTION_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<ExecutionChangeEvent>>() {
                    }));
        }
        String topic = APIConstants.API_EXECUTION_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onLevel3Data(WSCallback<WSEvent<Level3ChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_LEVEL3_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<Level3ChangeEvent>>() {
                    }));
        }
        String topic = APIConstants.API_LEVEL3_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onContractMarketData(WSCallback<WSEvent<ContractMarketEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_CONTRACT_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<ContractMarketEvent>>() {
                    }));
        }
        String topic = APIConstants.API_CONTRACT_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }

    @Override
    public String onSystemAnnouncement(WSCallback<WSEvent<AnnouncementEvent>> callback) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_ANNOUNCEMENT_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<AnnouncementEvent>>() {
                    }));
        }
        String topic = APIConstants.API_ANNOUNCEMENT_TOPIC_PREFIX;
        return subscribe(topic, false, true);
    }

    @Override
    public String onTransactionStatistic(WSCallback<WSEvent<TransactionStatisticEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_TRANSACTION_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<TransactionStatisticEvent>>() {
                    }));
        }
        String topic = APIConstants.API_TRANSACTION_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, false, true);
    }
}
