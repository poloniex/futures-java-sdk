package com.poloniex.futures.rest.v3;

import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.AccountV3Client;
import com.poloniex.futures.rest.impl.AccountV3ClientImpl;
import com.poloniex.futures.rest.req.AccountBalanceV3Request;
import org.junit.Test;

/**
 * @auther zhengxin
 * @date 2024/2/26
 */
public class AccountV3ClientTest {
    @Test
    public void test_getAccountOverview() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
//                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        AccountV3Client client = new AccountV3ClientImpl(options);
        client.getAccountOverview(
                AccountBalanceV3Request.builder().ccy("USDT").build());
//        System.out.println(JSON.toJSONString(result));
    }
}
