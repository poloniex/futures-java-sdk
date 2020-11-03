package com.poloniex.futures.websocket.strategy;

import com.poloniex.futures.model.InstanceServer;

import java.util.List;
import java.util.Random;

public class RandomChooseStrategy implements ChooseServerStrategy {

    private final Random random = new Random();

    @Override
    public InstanceServer choose(List<InstanceServer> servers) {
        return servers.get(random.nextInt(servers.size()));
    }

}
