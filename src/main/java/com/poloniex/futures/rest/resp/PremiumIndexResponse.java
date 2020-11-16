package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.market.PremiumIndex;
import lombok.Data;

import java.util.List;

@Data
public class PremiumIndexResponse {

    private List<PremiumIndex> dataList;
    private Boolean hasMore;

}
