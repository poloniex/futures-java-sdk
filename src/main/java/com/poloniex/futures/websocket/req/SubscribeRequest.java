package com.poloniex.futures.websocket.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SubscribeRequest {

    private String id;
    private String type;
    private String topic;
    private Boolean privateChannel;
    private Boolean response;
}
