package com.poloniex.futures.websocket.strategy;

import com.poloniex.futures.model.InstanceServer;

import java.util.List;

public interface ChooseServerStrategy {

    InstanceServer choose(List<InstanceServer> servers);

}
