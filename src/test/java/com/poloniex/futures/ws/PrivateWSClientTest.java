package com.poloniex.futures.ws;

import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.rest.event.AccountChangeEvent;
import com.poloniex.futures.rest.event.OrderChangeEvent;
import com.poloniex.futures.rest.event.PositionChangeEvent;
import com.poloniex.futures.rest.event.StopOrderLifecycleEvent;
import com.poloniex.futures.utils.IdGenerator;
import com.poloniex.futures.websocket.PrivateWSClient;
import com.poloniex.futures.websocket.impl.PrivateWSClientImpl;
import com.poloniex.futures.websocket.listener.PoloWebsocketListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class PrivateWSClientTest {

    private static final Logger log = LoggerFactory.getLogger(PublicWSClientTest.class);

    private PrivateWSClient wsClient;

    private Timer timer;

    static Long maxAwait = 1200L;

    private static final String SYMBOL = "BTCUSDTPERP";

    @Before
    public void setUp() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        wsClient = new PrivateWSClientImpl(options, new PoloWebsocketListener());
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
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY)
                .secretKey(Constants.SECRET_KEY)
                .passphrase(Constants.PASS_PHRASE)
                .restHost(Constants.REST_HOST)
                .build();
        PoloWebsocketListener listener = new PoloWebsocketListener();
        PrivateWSClient client = new PrivateWSClientImpl(options, listener);
        client.connect();
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
    public void onOrderChange() throws Exception {
        AtomicReference<OrderChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onOrderChange(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_ORDER_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        });
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
    }


    @Test
    public void onStopOrderLifecycle() throws Exception {
        AtomicReference<StopOrderLifecycleEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        wsClient.onStopOrderLifecycle(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_LIFECYCLE_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        });
        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
    }

    @Test
    public void onAccountBalance() throws Exception {
        AtomicReference<AccountChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);

        wsClient.onAccountBalance(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_BALANCE_TOPIC_PREFIX);
            cdl.countDown();
        });

        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
    }


    @Test
    public void onPositionChange() throws Exception {
        AtomicReference<PositionChangeEvent> event = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);

        wsClient.onPositionChange(response -> {
            event.set(response.getData());
            wsClient.unsubscribe(APIConstants.API_POSITION_TOPIC_PREFIX, SYMBOL);
            cdl.countDown();
        }, SYMBOL);

        assertTrue(cdl.await(maxAwait, TimeUnit.SECONDS));
        assertThat(event.get(), notNullValue());
    }

}
