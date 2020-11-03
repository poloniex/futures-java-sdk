package com.poloniex.futures.connection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.poloniex.futures.exception.SDKException;
import com.poloniex.futures.utils.UrlParamsBuilder;
import lombok.Getter;
import okhttp3.Request;

public class PoloiRestConnection {

    @Getter
    private Options options;

    public PoloiRestConnection(Options options) {
        this.options = options;
        ConnectionFactory.init(options.getApiKey(), options.getSecretKey(), options.getPassphrase());
    }

    public JSONObject executeGet(String path, UrlParamsBuilder paramsBuilder) {
        Options options = this.getOptions();
        String url = options.getRestHost() + path + paramsBuilder.buildUrl();
        Request executeRequest = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        String resp = ConnectionFactory.execute(executeRequest);
        return checkAndGetResponse(resp);
    }

    public JSONObject executePost(String path, UrlParamsBuilder paramsBuilder) {
        Options options = this.getOptions();
        String url = options.getRestHost() + path;
        Request executeRequest = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(paramsBuilder.buildPostBody())
                .build();
        String resp = ConnectionFactory.execute(executeRequest);
        return checkAndGetResponse(resp);
    }

    public JSONObject executeGetWithSignature(String path, UrlParamsBuilder paramsBuilder) {
        Options options = this.getOptions();
        String url = options.getRestHost() + path + paramsBuilder.buildUrl();
        Request executeRequest = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        String resp = ConnectionFactory.executeWithSignature(executeRequest);
        return checkAndGetResponse(resp);
    }

    public JSONObject executePostWithSignature(String path, UrlParamsBuilder paramsBuilder) {
        Options options = this.getOptions();
        String requestUrl = options.getRestHost() + path;
        Request executeRequest = new Request.Builder()
                .url(requestUrl)
                .addHeader("Content-Type", "application/json")
                .post(paramsBuilder.buildPostBody())
                .build();
        String resp = ConnectionFactory.executeWithSignature(executeRequest);
        return checkAndGetResponse(resp);
    }

    public JSONObject executeDeleteWithSignature(String path, UrlParamsBuilder paramsBuilder) {
        Options options = this.getOptions();
        String requestUrl = options.getRestHost() + path;
        Request executeRequest = new Request.Builder()
                .url(requestUrl)
                .addHeader("Content-Type", "application/json")
                .delete(paramsBuilder.buildPostBody())
                .build();
        String resp = ConnectionFactory.executeWithSignature(executeRequest);
        return checkAndGetResponse(resp);
    }

    private JSONObject checkAndGetResponse(String resp) {
        JSONObject json = JSON.parseObject(resp);
        try {
            if (json.containsKey("code")) {
                int code = json.getInteger("code");
                if (code != 200000) {
                    String message = json.getString("message");
                    throw new SDKException(SDKException.EXEC_ERROR, "[Executing]" + message);
                }
            } else {
                throw new SDKException(SDKException.RUNTIME_ERROR, "[Invoking] Status cannot be found in response.");
            }
        } catch (SDKException e) {
            throw e;
        } catch (Exception e) {
            throw new SDKException(SDKException.RUNTIME_ERROR, "[Invoking] Unexpected error: " + e.getMessage());
        }

        return json;
    }

}
