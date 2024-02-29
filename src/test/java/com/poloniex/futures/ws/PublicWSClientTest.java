package com.poloniex.futures.ws;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.event.ContractMarketEvent;
import com.poloniex.futures.rest.event.ExecutionChangeEvent;
import com.poloniex.futures.rest.event.Level2ChangeEvent;
import com.poloniex.futures.rest.event.Level2OrderBookEvent;
import com.poloniex.futures.rest.event.Level3ChangeEvent;
import com.poloniex.futures.rest.event.TickerChangeEvent;
import com.poloniex.futures.rest.event.TransactionStatisticEvent;
import com.poloniex.futures.utils.IdGenerator;
import com.poloniex.futures.websocket.PublicWSClient;
import com.poloniex.futures.websocket.impl.PublicWSClientImpl;
import com.poloniex.futures.websocket.listener.PoloWebsocketListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublicWSClientTest {

    private static final Logger log = LoggerFactory.getLogger(PublicWSClientTest.class);

    private PublicWSClient wsClient;

    private Timer timer;

    static Long maxAwait = 1200L;

    private static final String SYMBOL = "BTCUSDTPERP";


    @Before
    public void setUp() {
        Options options = PoloOptions.builder()
                .restHost(Constants.REST_HOST)
                .build();
        wsClient = new PublicWSClientImpl(options, new PoloWebsocketListener());
        wsClient.connect();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                wsClient.ping(IdGenerator.getNextId() + "");
            }
        }, 5000, 5000);
    }

    @After
    public void after() {
        timer.cancel();
        wsClient.close();
    }

    @Test
    @Ignore
    public void test_connect_and_ping_close() {
        PoloWebsocketListener listener = new PoloWebsocketListener();
        PublicWSClient client = new PublicWSClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST_NG_STG).build(), listener);
        client.ping("1");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.ping("1");
        client.close();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_onTicker() throws Exception {
        AtomicReference<TickerChangeEvent> event = new AtomicReference<>();
//        CountDownLatch cdl = new CountDownLatch(1);
        String uuid = wsClient.onTicker(response -> {
//            event.set(response.getData());
//            wsClient.unsubscribe(APIConstants.API_TICKER_TOPIC_PREFIX, SYMBOL);
//            cdl.countDown();
            System.out.println(JSON.toJSON(response.getData()));
        }, SYMBOL);
        LockSupport.park();
        System.out.println(uuid);
//        cdl.await(maxAwait, TimeUnit.SECONDS);

    }

    @Test
    public void test_onLevel2Data() throws Exception {
        AtomicReference<Level2ChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onLevel2Data(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_LEVEL2_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        MatcherAssert.assertThat(event.get(), notNullValue());
        log.info("event is " + JSON.toJSONString(event));
    }

    @Test
    public void test_onLevel2Depth5Data() throws Exception {
        AtomicReference<Level2OrderBookEvent> depth5Event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onLevel2Depth5Data(response -> {
            depth5Event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_LEVEL2_DEPTH_5_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        MatcherAssert.assertThat(depth5Event.get(), notNullValue());
        log.info("depth5Event is " + JSON.toJSONString(depth5Event));
    }

    @Test
    public void test_onLevel2Depth5oData() throws Exception {
        AtomicReference<Level2OrderBookEvent> depth50Event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onLevel2Depth50Data(response -> {
            depth50Event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_LEVEL2_DEPTH_50_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        MatcherAssert.assertThat(depth50Event.get(), notNullValue());
        log.info("depth50Event is " + JSON.toJSONString(depth50Event));
    }

    @Test
    public void onMatchExecutionData() throws Exception {
        AtomicReference<ExecutionChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onExecutionData(response -> {
            System.out.println(response);
//            event.set(response.getData());
//            wsClient.unsubscribe(APIConstants.API_EXECUTION_TOPIC_PREFIX, SYMBOL);
//            cdl.countDown();
        }, SYMBOL);
        LockSupport.park();
//        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
//        assertThat(event.get(), notNullValue());
        log.info("event is " + JSON.toJSONString(event));
    }

    @Test
    public void onLevel3Data() throws Exception {
        AtomicReference<Level3ChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onLevel3Data(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_LEVEL3_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);

        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
        log.info("event is " + JSON.toJSONString(event));
    }

    @Test
    public void onContractMarketData() throws Exception {
        AtomicReference<ContractMarketEvent> event = new AtomicReference<>();
//        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onContractMarketData(response -> {
            System.out.println(response.getData());
//            event.set(response.getData());
//            wsClient.unsubscribe(APIConstants.API_CONTRACT_TOPIC_PREFIX, SYMBOL);
//            cdl.countDown();
        }, SYMBOL);
        LockSupport.park();
//        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
//        assertThat(event.get(), notNullValue());
        log.info("event is " + JSON.toJSONString(event));
    }

    @Test
    public void onTransactionStatistic() throws Exception {
        AtomicReference<TransactionStatisticEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onTransactionStatistic(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_TRANSACTION_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
    }
}
