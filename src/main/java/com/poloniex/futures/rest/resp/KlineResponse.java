package com.poloniex.futures.rest.resp;

import lombok.Data;

import java.util.List;

@Data
public class KlineResponse {

    List<List<String>> data;

}
