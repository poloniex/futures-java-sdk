package com.poloniex.futures.websocket.impl;

import com.alibaba.fastjson.TypeReference;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.rest.callback.WSCallback;
import com.poloniex.futures.rest.event.*;
import com.poloniex.futures.websocket.PrivateWSClient;
import com.poloniex.futures.websocket.listener.PoloWebsocketListener;
import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;
import com.poloniex.futures.websocket.token.WebSocketTokenClient;
import com.poloniex.futures.websocket.token.WebSocketTokenClientImpl;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrivateWSClientImpl extends BaseWebsocketImpl implements PrivateWSClient {

    private WebSocketTokenClient tokenClient;

    public PrivateWSClientImpl(Options options, PoloWebsocketListener websocketListener) {
        super(options, websocketListener);
        this.tokenClient = new WebSocketTokenClientImpl(options);
    }

    @Override
    protected WebSocketTokenResponse requestToken() {
        return tokenClient.getPrivateToken();
    }

    @Override
    public String unsubscribe(String topicPrefix, String... symbols) {
        return super.unsubscribe(topicPrefix + Arrays.stream(symbols).collect(Collectors.joining(",")),
                false, true);
    }

    @Override
    public String onOrderChange(WSCallback<WSEvent<OrderChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_ORDER_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<OrderChangeEvent>>() {
                    }));
        }
        return subscribe(APIConstants.API_ORDER_TOPIC_PREFIX, true, true);
    }

    @Override
    public String onStopOrderLifecycle(WSCallback<WSEvent<StopOrderLifecycleEvent>> callback) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_LIFECYCLE_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<StopOrderLifecycleEvent>>() {
                    }));
        }
        return subscribe(APIConstants.API_LIFECYCLE_TOPIC_PREFIX, true, true);
    }

    @Override
    public String onAccountBalance(WSCallback<WSEvent<AccountChangeEvent>> callback) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_BALANCE_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<AccountChangeEvent>>() {
                    }));
        }
        return subscribe(APIConstants.API_BALANCE_TOPIC_PREFIX, true, true);
    }

    @Override
    public String onPositionChange(WSCallback<WSEvent<PositionChangeEvent>> callback, String... symbols) {
        if (callback != null) {
            this.getWebsocketListener().getCallbackMap().put(APIConstants.API_POSITION_TOPIC_PREFIX,
                    Pair.of(callback, new TypeReference<WSEvent<PositionChangeEvent>>() {
                    }));
        }
        String topic = APIConstants.API_POSITION_TOPIC_PREFIX + Arrays.stream(symbols).collect(Collectors.joining(","));
        return subscribe(topic, true, true);
    }
}
