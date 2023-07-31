package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.util.List;

@Data
public class UserContractLotSizeResponse {
    List<UserContractLotSize> data;
}
