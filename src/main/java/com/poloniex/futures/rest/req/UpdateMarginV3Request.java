package com.poloniex.futures.rest.req;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpdateMarginV3Request {
    private String symbol;
    private BigDecimal amt;
    private String posSide;
}
