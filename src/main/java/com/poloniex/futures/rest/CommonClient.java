package com.poloniex.futures.rest;

import com.poloniex.futures.rest.resp.ServiceStatusResponse;

public interface CommonClient {

    Long time();

    ServiceStatusResponse status();

}
