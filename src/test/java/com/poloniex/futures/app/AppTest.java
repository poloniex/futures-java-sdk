package com.poloniex.futures.app;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.poloniex.futures.app.APPConstants.*;


@Slf4j
public class AppTest {


    private String HOST = "https://dev-ng-sapi.poloniex.com/";
    private String TOKEN = "070a595afe0c4132a7037aac3fcc38e3";


    @Test
    public void test1() {
        Map<String, Object> param = new ConcurrentHashMap<>();
        param.put("symbol", "btc");
        String body = httpGetNoAUTH(contract_info)
                .body(JSON.toJSONString(param))
                .execute().body();
        log.info("body:{}", body);
    }


    @Test
    public void test2() {
        String body = httpGetNoAUTH(contracts_info)
                .execute().body();
        log.info("body:{}", body);
    }


    @Test
    public void test3() {
        String body = httpGetNoAUTH(market_list)
                .execute().body();
        log.info("body:{}", body);
    }



    @Test
    public void test4() {
        String body = httpGetNoAUTH(kline_list)
                .execute().body();
        log.info("body:{}", body);
    }


    @Test
    public void test5() {
        String body = httpGetAUTH(open_contract)
                .execute().body();
        log.info("body:{}", body);
    }




    @Test
    public void test12() {
        String body = httpGetAUTH(favorite_symbol).execute().body();
        log.info("body:{}", body);
    }


    public HttpRequest httpGetAUTH(String url) {
        HttpRequest httpGet = HttpUtil.createGet(HOST + url);
        httpGet.header("POLOSESSID", TOKEN);
        return httpGet;
    }


    public HttpRequest httpGetNoAUTH(String url) {
        HttpRequest httpGet = HttpUtil.createGet(HOST + url);
        return httpGet;
    }


}
