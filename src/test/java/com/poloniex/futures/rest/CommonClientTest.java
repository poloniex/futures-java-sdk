package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.rest.resp.ServiceStatusResponse;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.rest.impl.CommonClientImpl;
import org.junit.Test;

public class CommonClientTest {

    @Test
    public void test_status() {
        CommonClient client = new CommonClientImpl(PoloOptions.builder().build());
        ServiceStatusResponse result = client.status();
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_time() {
        CommonClient client = new CommonClientImpl(PoloOptions.builder().build());
        Long result = client.time();
        System.out.println(JSON.toJSON(result));
    }

}
