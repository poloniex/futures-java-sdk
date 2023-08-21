package com.poloniex.futures.rest.resp;



import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrialAccountOverview implements Serializable {
    private BigDecimal totalBalance = BigDecimal.ZERO;

    private BigDecimal availableBalance = BigDecimal.ZERO;

    private BigDecimal holdBalance = BigDecimal.ZERO;
}
