package com.poloniex.futures.rest.req;


import java.util.List;
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
public class BatchCancelOrdersRequest {

    private List<String> orderIds;

    private List<String> clientOids;
}
