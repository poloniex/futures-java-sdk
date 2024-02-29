package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.impl.AccountClientImpl;
import com.poloniex.futures.rest.req.AccountOverviewRequest;
import com.poloniex.futures.rest.req.TransactionHistoryRequest;
import com.poloniex.futures.rest.req.TransferInRequest;
import com.poloniex.futures.rest.resp.AccountOverviewResponse;
import com.poloniex.futures.rest.resp.TransactionHistoryResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import lombok.SneakyThrows;
import org.junit.Test;

public class AccountClientTest {

    @Test
    public void test_getAccountOverview() {
        Options options = PoloOptions.builder()
//                .apiKey(Constants.API_KEY_NG_PROD_0)
//                .secretKey(Constants.SECRET_KEY_PROD_0)
//                .passphrase(Constants.PASS_PHRASE_PROD_0)
//                .restHost(Constants.REST_HOST_NG_PROD)
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        AccountClient client = new AccountClientImpl(options);
        AccountOverviewResponse result = client.getAccountOverview(AccountOverviewRequest.builder().currency("USDT").build());
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getInternalAccountOverview() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_STG_INTERNAL)
                .secretKey(Constants.SECRET_KEY_STG_INTERNAL)
                .passphrase(Constants.PASS_PHRASE_STG_INTERNAL)
                .restHost(Constants.REST_HOST_NG_STG_INTERNAL)
                .build();
        AccountClient client = new AccountClientImpl(options);
        client.getInternalAccountOverview("1006463");
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_getTransactionHistory() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_TEST_7)
                .secretKey(Constants.SECRET_KEY_TEST_7)
                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        AccountClient client = new AccountClientImpl(options);
        TransactionHistoryResponse result = client.getTransactionHistory(TransactionHistoryRequest.builder()
                        .currency("USDT")
                        .maxCount(100L)
                .build());
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    @SneakyThrows
    public void test_transferInDevSingle() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.API_KEY_NG_DEV_INTERNAL)
                .secretKey(Constants.SECRET_KEY_NG_DEV_INTERNAL)
                .passphrase(Constants.PASS_PHRASE_NG_DEV_INTERNAL)
                .restHost(Constants.REST_HOST_NG_DEV_INTERNAL)
                .build();
        AccountClient client = new AccountClientImpl(options);

        TransferInRequest request = TransferInRequest.builder()
                .bizNo(System.currentTimeMillis())
                .userId("1001")
                .amount("10000")
                .currency("USDT")
                .build();
        System.out.println(client.transferIn(request));
    }

    @Test
    @SneakyThrows
    public void test_transferIn() {
        Options options = PoloOptions.builder()
//                .apiKey(Constants.API_KEY_NG_STG_INTERNAL)
//                .secretKey(Constants.SECRET_KEY_STG_INTERNAL)
//                .passphrase(Constants.PASS_PHRASE_STG_INTERNAL)
//                .restHost(Constants.REST_HOST_STG_INTERNAL)
//                .apiKey(Constants.API_KEY_NG_DEV_INTERNAL)
//                .secretKey(Constants.SECRET_KEY_NG_DEV_INTERNAL)
//                .passphrase(Constants.PASS_PHRASE_NG_DEV_INTERNAL)
//                .restHost(Constants.REST_HOST_NG_DEV_INTERNAL)
                .apiKey(Constants.API_KEY_NG_PROD_0)
                .secretKey(Constants.SECRET_KEY_PROD_0)
                .passphrase(Constants.PASS_PHRASE_PROD_0)
                .restHost(Constants.REST_HOST_NG_PROD)
                .build();
        AccountClient client = new AccountClientImpl(options);
        AtomicLong bizNo = new AtomicLong(System.currentTimeMillis());
        Files.lines(Paths.get(this.getClass().getClassLoader().getResource("userId.txt").toURI()),
                        StandardCharsets.UTF_8)
                .forEach(userId -> {
                    TransferInRequest request = TransferInRequest.builder()
                            .bizNo(bizNo.incrementAndGet())
                            .userId(userId)
                            .amount("10000")
                            .currency("USDT").build();
                    System.out.println(client.transferIn(request));
                });
    }

    @Test
    @SneakyThrows
    public void test_transferInSingle() {
        Options options = PoloOptions.builder()
//                .apiKey(Constants.API_KEY_NG_STG_INTERNAL)
//                .secretKey(Constants.SECRET_KEY_STG_INTERNAL)
//                .passphrase(Constants.PASS_PHRASE_STG_INTERNAL)
//                .restHost(Constants.REST_HOST_STG_INTERNAL)
                .apiKey(Constants.API_KEY_NG_PROD_0)
                .secretKey(Constants.SECRET_KEY_PROD_0)
                .passphrase(Constants.PASS_PHRASE_PROD_0)
                .restHost(Constants.REST_HOST_NG_PROD)
                .build();
        AccountClient client = new AccountClientImpl(options);

        TransferInRequest request = TransferInRequest.builder()
                .bizNo(System.currentTimeMillis())
                .userId("1386225")
                .amount("10000")
                .currency("USDT").build();
        System.out.println(client.transferIn(request));
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
