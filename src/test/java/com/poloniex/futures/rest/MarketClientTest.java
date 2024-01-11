package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.constant.Constants;
import com.poloniex.futures.rest.impl.MarketClientImpl;
import com.poloniex.futures.rest.req.ContractInfoRequest;
import com.poloniex.futures.rest.req.CurrentFundingRateRequest;
import com.poloniex.futures.rest.req.CurrentMarkPriceRequest;
import com.poloniex.futures.rest.req.IndexRequest;
import com.poloniex.futures.rest.req.InterestRateRequest;
import com.poloniex.futures.rest.req.KlineRequest;
import com.poloniex.futures.rest.req.MarketTicker24hrRequest;
import com.poloniex.futures.rest.req.MarketTickerRequest;
import com.poloniex.futures.rest.req.OrderBookPullingRequest;
import com.poloniex.futures.rest.req.OrderBookRequest;
import com.poloniex.futures.rest.req.PremiumIndexRequest;
import com.poloniex.futures.rest.req.TradeHistoryRequest;
import com.poloniex.futures.rest.resp.ContractResponse;
import com.poloniex.futures.rest.resp.CurrentFundingRateResponse;
import com.poloniex.futures.rest.resp.CurrentMarkPriceResponse;
import com.poloniex.futures.rest.resp.IndexResponse;
import com.poloniex.futures.rest.resp.InterestRateResponse;
import com.poloniex.futures.rest.resp.KlineResponse;
import com.poloniex.futures.rest.resp.MarketTicker24hrResponse;
import com.poloniex.futures.rest.resp.MarketTickerResponse;
import com.poloniex.futures.rest.resp.OrderBookL2Response;
import com.poloniex.futures.rest.resp.OrderBookL3Response;
import com.poloniex.futures.rest.resp.PremiumIndexResponse;
import com.poloniex.futures.rest.resp.TradeHistoryResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class MarketClientTest {

    @Test
    public void test_getOpenContractList() {
        MarketClient client = new MarketClientImpl(
                PoloOptions.builder().restHost(Constants.REST_HOST_NG_TEST).build());
        List<ContractResponse> result = client.getOpenContractList();
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getContractInfo() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        ContractInfoRequest request = ContractInfoRequest.builder().symbol("BTCUSDTPERP").build();
        ContractResponse result = client.getContractInfo(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getRealTimeTicker() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().restHost(Constants.REST_HOST_NG_TEST).build());
        MarketTickerRequest request = MarketTickerRequest.builder().symbol("BTCUSDTPERP").build();
        MarketTickerResponse result = client.getRealTimeTicker(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getTicker24hr() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().restHost(Constants.REST_HOST_NG_TEST).build());
        MarketTicker24hrRequest request = MarketTicker24hrRequest.builder().symbol("BTCUSDTPERP").build();
        MarketTicker24hrResponse result = client.getTicker24hr(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getFullOrderBookL2() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().restHost(Constants.REST_HOST_NG_TEST).build());
        OrderBookRequest request = OrderBookRequest.builder().symbol("BTCUSDTPERP").build();
        OrderBookL2Response result = client.getFullOrderBookL2(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getFullOrderBookL2Pulling() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        OrderBookPullingRequest request = OrderBookPullingRequest.builder().symbol("BTCUSDTPERP").start(1596583272590L).end(1596583272590L).build();
        OrderBookL2Response result = client.getFullOrderBookL2Pulling(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getFullOrderBookL3() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        OrderBookRequest request = OrderBookRequest.builder().symbol("BTCUSDTPERP").build();
        OrderBookL3Response result = client.getFullOrderBookL3(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getTradeHistory() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST_NG_TEST).build());
        TradeHistoryRequest request = TradeHistoryRequest.builder().symbol("BTCUSDTPERP").build();
        List<TradeHistoryResponse> result = client.getTradeHistory(request);
        System.out.println(result.size());
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getInterestRateList() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST_NG_STG_INTERNAL).build());
        InterestRateRequest request = InterestRateRequest.builder().symbol(".ETHINT").build();
        InterestRateResponse result = client.getInterestRateList(request);
        System.out.println(result.getDataList().size());
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getIndexList() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        IndexRequest request = IndexRequest.builder().symbol(".PXBTUSDT").startAt(1603734839000L).build();
        IndexResponse result = client.getIndexList(request);
        System.out.println(result.getDataList().size());
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getCurrentMarkPrice() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().restHost(Constants.REST_HOST_OLD_STG).build());
        CurrentMarkPriceRequest request = CurrentMarkPriceRequest.builder().symbol("ETHUSDTPERP").build();
        CurrentMarkPriceResponse result = client.getCurrentMarkPrice(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getPremiumIndex() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST_NG_TEST).build());
        PremiumIndexRequest request = PremiumIndexRequest.builder().symbol(".BTCUSDTPERPPI").startAt(" ").reverse("av").build();
        PremiumIndexResponse result = client.getPremiumIndex(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_CurrentFundingRateResponse() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST_NG_TEST).build());
        CurrentFundingRateRequest request = CurrentFundingRateRequest.builder()
                .symbol(".BTCUSDTPERPFPI8H")
                .maxCount(2)
                .offset(2L)
                .build();
        CurrentFundingRateResponse result = client.getCurrentFundingRate(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_KlineRequest() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder()
                .restHost(Constants.REST_HOST).build());
//symbol=.BTCUSDTPERPPI8H&granularity=1&from=1702767840000&to=1702785600000&limit=800
//        /futures-kline/v1/kline/query?symbol=.BTCUSDTPERPPI&granularity=1&from=&to=1702884479000&limit=800&lang=en_US
        KlineRequest request = KlineRequest.builder()
//                .symbol("BTCUSDTPERP")
                .symbol(".BTCUSDTPERPPI8H")
                .granularity(1).build();
        KlineResponse result = client.getKline(request);
        System.out.println(JSON.toJSON(result));
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(\\.).*(PI|PI8H)$");
        String symbol = "BTCUSDTPERPPI";
        Matcher matcher = pattern.matcher(symbol);
//        System.out.println(matcher.matches());
//        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(matcher.group());
//            symbol = matcher.group(0).replace(".", "");
//            symbol = matcher.group(2).replace(".", "");
        }
        System.out.println(symbol);

//            symbol = matcher.gr
//        }

    }
    /**
     BTCUSDTPERP
     ETHUSDTPERP
     BCHUSDTPERP
     TRXUSDTPERP
     XRPUSDTPERP
     LTCUSDTPERP
     DOGEUSDTPERP
     BNBUSDTPERP
     1000SHIBUSDTPERP
     SOLUSDTPERP
     AVAXUSDTPERP
     APTUSDTPERP
     1000PEPEUSDTPERP
     */
}