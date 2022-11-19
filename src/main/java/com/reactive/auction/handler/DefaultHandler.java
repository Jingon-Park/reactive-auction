package com.reactive.auction.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DefaultHandler {

    public Mono<ServerResponse> welcome(ServerRequest request){
        return ServerResponse.ok().build();


    }
}
