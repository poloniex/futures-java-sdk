package com.poloniex.futures.connection;

import com.poloniex.futures.websocket.strategy.ChooseServerStrategy;

public interface Options {

    String getApiKey();

    String getSecretKey();

    String getPassphrase();

    String getRestHost();

    ChooseServerStrategy getChooseServerStrategy();
}
