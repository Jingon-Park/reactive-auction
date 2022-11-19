package com.reactive.auction.config.router;

import com.reactive.auction.handler.DefaultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class Router {

    private final DefaultHandler defaultHandler;

    @Bean
    public RouterFunction<ServerResponse> getRouter(){
        return RouterFunctions.route(GET("welcome"), defaultHandler::welcome);
    }





}
