package com.poloniex.futures.websocket.req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PingRequest {

    private String id;
    private String type;
}
