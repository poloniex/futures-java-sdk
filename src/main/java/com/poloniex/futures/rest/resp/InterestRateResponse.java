package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.market.InterestRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class InterestRateResponse {

    private List<InterestRate> dataList;
    private Boolean hasMore;

}
