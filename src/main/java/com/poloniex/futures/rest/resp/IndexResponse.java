package com.poloniex.futures.rest.resp;

import com.poloniex.futures.model.market.IndexComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class IndexResponse {

    private List<IndexComponent> dataList;
    private Boolean hasMore;

}
