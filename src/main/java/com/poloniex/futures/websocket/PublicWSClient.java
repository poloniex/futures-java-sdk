package com.poloniex.futures.websocket;

import com.poloniex.futures.rest.callback.WSCallback;
import com.poloniex.futures.rest.event.*;

public interface PublicWSClient {

    void connect() ;

    void close();

    String ping(String requestId);
    
    String unsubscribe(String topicPrefix, String... symbols);

    String onTicker(WSCallback<WSEvent<TickerChangeEvent>> callback, String... symbols);

    String onLevel2Data(WSCallback<WSEvent<Level2ChangeEvent>> callback, String... symbols);

    String onLevel2Depth5Data(WSCallback<WSEvent<Level2OrderBookEvent>> callback, String... symbols);

    String onLevel2Depth50Data(WSCallback<WSEvent<Level2OrderBookEvent>> callback, String... symbols);

    String onExecutionData(WSCallback<WSEvent<ExecutionChangeEvent>> callback, String... symbols);

    String onLevel3Data(WSCallback<WSEvent<Level3ChangeEvent>> callback, String... symbols);

    String onContractMarketData(WSCallback<WSEvent<ContractMarketEvent>> callback, String... symbols);

    String onSystemAnnouncement(WSCallback<WSEvent<AnnouncementEvent>> callback);

    String onTransactionStatistic(WSCallback<WSEvent<TransactionStatisticEvent>> callback, String... symbols);
}
