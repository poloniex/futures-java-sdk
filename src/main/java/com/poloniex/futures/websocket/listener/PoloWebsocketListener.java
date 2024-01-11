package com.poloniex.futures.websocket.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.poloniex.futures.rest.callback.WSCallback;
import com.poloniex.futures.rest.event.WSEvent;
import com.poloniex.futures.utils.JSONUtils;
import lombok.Getter;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PoloWebsocketListener extends WebSocketListener {

    private static final Logger log = LoggerFactory.getLogger(PoloWebsocketListener.class);

    @Getter
    private Map<String, Pair<WSCallback, TypeReference>> callbackMap = new HashMap<>();

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.debug("web socket open");
    }

    public void onMessage(WebSocket webSocket, String text) {
        log.info("Got message: {}", text);
        JSONObject jsonObject = JSON.parseObject(text);
        String type = jsonObject.getString("type");
        if (!type.equals("message")) {
            log.debug("Ignoring message type ({})", type);
            return;
        }
        String topic = jsonObject.getString("topic");
        Optional<String> callback = callbackMap.keySet().stream().filter(topic::contains).findFirst();
        if (callback.isPresent()) {
            Pair<WSCallback, TypeReference> pair = callbackMap.get(callback.get());
            Object event = JSONObject.parseObject(text, pair.getRight());
            pair.getLeft().onResponse(event);
        }
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        log.error("Error on socket", t);
    }

}
