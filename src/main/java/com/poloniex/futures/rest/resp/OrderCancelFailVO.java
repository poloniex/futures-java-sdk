package com.poloniex.futures.rest.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelFailVO {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单状态，用于追踪错误原因
     */
    private Integer orderState;

    private String clientOid;
}
