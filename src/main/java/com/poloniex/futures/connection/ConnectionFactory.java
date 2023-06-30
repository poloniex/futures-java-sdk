package com.poloniex.futures.connection;

import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.exception.SDKException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ConnectionFactory {

    private static final Logger log = LoggerFactory.getLogger(ConnectionFactory.class);

    private static volatile boolean inited;
    private static volatile boolean authed;

    private static OkHttpClient client;

    private static Long connectTimeout = 5000L;
    private static Long readTimeout = 5000L;
    private static Long writeTimeout = 5000L;

    public static void init(String apiKey, String secret, String passPhrase) {
        ConnectionPool connectionPool = new ConnectionPool(20, 300, TimeUnit.SECONDS);
        if (Objects.nonNull(apiKey) && Objects.nonNull(secret) && Objects.nonNull(passPhrase)) {
            Interceptor interceptor = new AuthenticationInterceptor(apiKey, secret, passPhrase);
            client = new OkHttpClient.Builder()
                    .followSslRedirects(false)
                    .followRedirects(false)
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    .addInterceptor(interceptor)
                    .connectionPool(connectionPool)
                    .build();
            authed = true;
        } else {
            client = new OkHttpClient.Builder()
                    .followSslRedirects(false)
                    .followRedirects(false)
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    .connectionPool(connectionPool)
                    .build();
        }
        inited = true;
    }

    public static String execute(Request request) {
        if (!inited) {
            throw new SDKException(SDKException.ENV_ERROR, "[Execute] ConnectionFactory not init");
        }
        Response response = null;
        String str = null;
        try {
            log.debug("[Request URL]{}", request.url());
            response = client.newCall(request).execute();
            if (response.code() != 200) {
                throw new SDKException(SDKException.EXEC_ERROR, "[Execute] Response Status Error : " + response.code() + " message:" + response.message());
            }
            if (response != null && response.body() != null) {
                str = response.body().string();
                response.close();
            } else {
                throw new SDKException(SDKException.ENV_ERROR, "[Execute] Cannot get the response from server");
            }
            log.debug("[Response]{}", str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            throw new SDKException(SDKException.RUNTIME_ERROR, "[Execute] Cannot get the response from server");
        }
    }

    public static String executeWithSignature(Request request) {
        if (!inited) {
            throw new SDKException(SDKException.ENV_ERROR, "[Execute] ConnectionFactory not init");
        }
        if (!authed) {
            throw new SDKException(SDKException.ENV_ERROR, "[Execute] ConnectionFactory not authed");
        }
        Response response = null;
        String str = null;
        try {
            log.info("[Request URL]{}", request.url());
            Request temp = request.newBuilder().addHeader(APIConstants.API_HEADER_NEED_AUTH, "true").build();
            response = client.newCall(temp).execute();
            if (response.code() != 200) {
                throw new SDKException(SDKException.EXEC_ERROR, "[Execute] Response Status Error : " + response.code() + " message:" + response.message());
            }
            if (response != null && response.body() != null) {
                str = response.body().string();
                response.close();
            } else {
                throw new SDKException(SDKException.ENV_ERROR, "[Execute] Cannot get the response from server");
            }
            log.debug("[Response]{}", str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            throw new SDKException(SDKException.RUNTIME_ERROR, "[Execute] Cannot get the response from server");
        }
    }

    public static WebSocket createWebSocket(Request request, WebSocketListener listener) {
        if (!inited) {
            throw new SDKException(SDKException.ENV_ERROR, "[Execute] ConnectionFactory not init");
        }
        return client.newWebSocket(request, listener);
    }

    public static void close() {
        client.dispatcher().executorService().shutdown();
        inited = false;
        authed = false;
    }
}
