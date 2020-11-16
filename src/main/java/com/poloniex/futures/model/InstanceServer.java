package com.poloniex.futures.model;

import lombok.Data;

@Data
public class InstanceServer {

    private Long pingInterval;
    private String endpoint;
    private String protocol;
    private Boolean encrypt;
    private Long pingTimeout;

}
