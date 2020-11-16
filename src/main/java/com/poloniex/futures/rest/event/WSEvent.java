package com.poloniex.futures.rest.event;

import lombok.Data;

import java.lang.reflect.ParameterizedType;

@Data
public class WSEvent<T> {

    private String id;

    private String userId;

    private String type;

    private String topic;

    private String subject;

    private String channelType;

    private Boolean privateChannel;

    private Boolean response;

    private T data;

}
