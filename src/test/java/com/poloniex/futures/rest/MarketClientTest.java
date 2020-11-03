package com.poloniex.futures.rest;

import com.alibaba.fastjson.JSON;
import com.poloniex.futures.rest.req.*;
import com.poloniex.futures.rest.resp.*;
import com.poloniex.futures.connection.PoloOptions;
import com.poloniex.futures.rest.impl.MarketClientImpl;
import org.junit.Test;

import java.util.List;

public class MarketClientTest {

    @Test
    public void test_getOpenContractList() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
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
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        MarketTickerRequest request = MarketTickerRequest.builder().symbol("BTCUSDTPERP").build();
        MarketTickerResponse result = client.getRealTimeTicker(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getTicker24hr() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        MarketTicker24hrRequest request = MarketTicker24hrRequest.builder().symbol("BTCUSDTPERP").build();
        MarketTicker24hrResponse result = client.getTicker24hr(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getFullOrderBookL2() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
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
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        TradeHistoryRequest request = TradeHistoryRequest.builder().symbol("BTCUSDTPERP").build();
        List<TradeHistoryResponse> result = client.getTradeHistory(request);
        System.out.println(result.size());
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getInterestRateList() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        InterestRateRequest request = InterestRateRequest.builder().symbol(".ETHINT").startAt(1603734839000L).build();
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
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        CurrentMarkPriceRequest request = CurrentMarkPriceRequest.builder().symbol("BTCUSDTPERP").build();
        CurrentMarkPriceResponse result = client.getCurrentMarkPrice(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_getPremiumIndex() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        PremiumIndexRequest request = PremiumIndexRequest.builder().symbol(".BTCUSDTPERPPI").build();
        PremiumIndexResponse result = client.getPremiumIndex(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_CurrentFundingRateResponse() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        CurrentFundingRateRequest request = CurrentFundingRateRequest.builder().symbol(".BTCUSDTPERPFPI8H").build();
        CurrentFundingRateResponse result = client.getCurrentFundingRate(request);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void test_KlineRequest() {
        MarketClient client = new MarketClientImpl(PoloOptions.builder().build());
        KlineRequest request = KlineRequest.builder().symbol("BTCUSDTPERP").granularity(1).build();
        KlineResponse result = client.getKline(request);
        System.out.println(JSON.toJSON(result));
    }

}