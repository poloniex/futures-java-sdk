package com.poloniex.futures.rest.v3;

import com.poloniex.futures.connection.Options;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.PositionV3Client;
import com.poloniex.futures.rest.impl.PositionV3ClientImpl;
import com.poloniex.futures.rest.req.QueryPosLeverageV3Request;
import com.poloniex.futures.rest.req.UpdateMarginV3Request;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @auther zhengxin
 * @date 2024/2/26
 */
public class PositionV3ClientTest {
    @Test
    public void test_UpdateMargin() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
//                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        PositionV3Client client = new PositionV3ClientImpl(options);
        client.updateMargin(
                UpdateMarginV3Request.builder().symbol("BNB_USDT_PERP").amt(new BigDecimal("10")).posSide("3").build());
//        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test_QueryPosLever() {
        Options options = PoloOptions.builder()
                .apiKey(Constants.SPOT_API_KEY_NG_TEST_7)
                .secretKey(Constants.SPOT_SECRET_KEY_NG_TEST_7)
//                .passphrase(Constants.PASS_PHRASE_TEST)
                .restHost(Constants.REST_HOST_NG_TEST)
                .build();
        PositionV3Client client = new PositionV3ClientImpl(options);
        client.queryPosLeverage(
                QueryPosLeverageV3Request.builder().symbol("BNB_USDT_PERP").build());
//        System.out.println(JSON.toJSONString(result));
    }
}
