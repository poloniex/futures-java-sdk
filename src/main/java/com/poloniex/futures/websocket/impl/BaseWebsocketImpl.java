package com.poloniex.futures.websocket.impl;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.connection.ConnectionFactory;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.model.InstanceServer;
import com.poloniex.futures.utils.IdGenerator;
import com.poloniex.futures.utils.JSONUtils;
import com.poloniex.futures.websocket.listener.PoloWebsocketListener;
import com.poloniex.futures.websocket.req.PingRequest;
import com.poloniex.futures.websocket.req.SubscribeRequest;
import com.poloniex.futures.websocket.resp.WebSocketTokenResponse;
import com.poloniex.futures.websocket.strategy.ChooseServerStrategy;
import lombok.Getter;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

public abstract class BaseWebsocketImpl implements Closeable {

    private static final Logger log = LoggerFactory.getLogger(BaseWebsocketImpl.class);

    @Getter
    private PoloWebsocketListener websocketListener;
    private ChooseServerStrategy chooseServerStrategy;
    private InstanceServer instanceServer;
    private WebSocket webSocket;
    private Options options;

    protected BaseWebsocketImpl(Options options, PoloWebsocketListener websocketListener) {
        this.options = options;
        this.chooseServerStrategy = options.getChooseServerStrategy();
        this.websocketListener = websocketListener;
        ConnectionFactory.init(options.getApiKey(), options.getSecretKey(), options.getPassphrase());
    }

    public void connect() {
        WebSocketTokenResponse websocketToken = requestToken();
        this.instanceServer = chooseServerStrategy.choose(websocketToken.getInstanceServers());
        String streamingUrl = String.format("%s", instanceServer.getEndpoint()
                + "?token=" + websocketToken.getToken() + "&acceptUserMessage=true");
        Request request = new Request.Builder().url(streamingUrl).build();
        this.webSocket = ConnectionFactory.createWebSocket(request, websocketListener);
    }

    protected abstract WebSocketTokenResponse requestToken();

    @Override
    public void close() {
        log.info("Web Socket Close");
        try {
            if (webSocket != null)
                webSocket.close(1000, "");
        } catch (Exception e) {
            log.error("Web Socket Close Error !!! ", e);
        }
    }

    public String ping(String requestId) {
        PingRequest ping = new PingRequest();
        ping.setId(requestId);
        ping.setType("ping");
        if (webSocket.send(serialize(ping))) {
            return requestId;
        }
        return null;
    }

    public String subscribe(String topic, boolean privateChannel, boolean response) {
        String uuid = IdGenerator.getNextId().toString();
        SubscribeRequest subscribe = new SubscribeRequest();
        subscribe.setId(uuid);
        subscribe.setType("subscribe");
        subscribe.setTopic(topic);
        subscribe.setPrivateChannel(privateChannel);
        subscribe.setResponse(response);
        log.debug(JSON.toJSONString(subscribe));
        if (webSocket.send(serialize(subscribe))) {
            return uuid;
        }
        return null;
    }

    public String unsubscribe(String topic, boolean privateChannel, boolean response) {
        String uuid = IdGenerator.getNextId().toString();
        SubscribeRequest subscribe = new SubscribeRequest();
        subscribe.setId(uuid);
        subscribe.setType("unsubscribe");
        subscribe.setTopic(topic);
        subscribe.setPrivateChannel(privateChannel);
        subscribe.setResponse(response);
        log.debug(JSON.toJSONString(subscribe));
        if (webSocket.send(serialize(subscribe))) {
            return uuid;
        }
        return null;
    }

    private String serialize(Object o) {
        return JSONUtils.toJSON(o);
    }

}
