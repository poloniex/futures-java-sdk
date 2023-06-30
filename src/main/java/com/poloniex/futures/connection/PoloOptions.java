package com.poloniex.futures.connection;

import com.poloniex.futures.websocket.strategy.ChooseServerStrategy;
import com.poloniex.futures.websocket.strategy.RandomChooseStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoloOptions implements Options {

    @Builder.Default
    private String restHost = "https://dev-ng-futures-api.poloniex.com";

    private String apiKey;

    private String secretKey;

    private String passphrase;

    @Override
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public String getSecretKey() {
        return this.secretKey;
    }

    @Override
    public String getPassphrase() {
        return this.passphrase;
    }

    @Override
    public String getRestHost() {
        return this.restHost;
    }
    
    @Override
    public ChooseServerStrategy getChooseServerStrategy() {
        return new RandomChooseStrategy();
    }
}
