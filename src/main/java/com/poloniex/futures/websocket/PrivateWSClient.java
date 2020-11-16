package com.poloniex.futures.websocket;

import com.poloniex.futures.rest.callback.WSCallback;
import com.poloniex.futures.rest.event.*;

public interface PrivateWSClient {

    void connect();

    void close();

    String ping(String requestId);

    String unsubscribe(String topic,  String... symbols);

    String onOrderChange(WSCallback<WSEvent<OrderChangeEvent>> callback, String... symbols);

    String onStopOrderLifecycle(WSCallback<WSEvent<StopOrderLifecycleEvent>> callback);

    String onAccountBalance(WSCallback<WSEvent<AccountChangeEvent>> callback);

    String onPositionChange(WSCallback<WSEvent<PositionChangeEvent>> callback, String... symbols);
}
