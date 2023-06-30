package com.poloniex.futures.rest.resp;

import lombok.Data;

@Data
public class UserOrderMaxActiveConfigResponse {
    private Integer maxOrder;
    private Integer maxStopOrder;
}
