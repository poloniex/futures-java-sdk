package com.poloniex.futures.rest.resp;

import lombok.Data;

@Data
public class UserContractLotSize {


    private String symbol;
    private Integer maxLot;
}
