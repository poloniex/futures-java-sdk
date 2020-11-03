package com.poloniex.futures.rest.callback;

import com.poloniex.futures.exception.SDKException;

public interface WSCallback<T> {

    void onResponse(T response) throws SDKException;

}
