package com.poloniex.futures.websocket.token;

import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;

public interface WebSocketTokenClient {

    WebSocketTokenResponse getPublicToken();

    WebSocketTokenResponse getPrivateToken();
}
