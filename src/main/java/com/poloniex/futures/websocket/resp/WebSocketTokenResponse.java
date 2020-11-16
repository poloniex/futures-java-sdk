package com.poloniex.futures.websocket.resp;

import com.poloniex.futures.model.InstanceServer;
import lombok.Data;

import java.util.List;

@Data
public class WebSocketTokenResponse {

    private String token;
    private List<InstanceServer> instanceServers;

}
