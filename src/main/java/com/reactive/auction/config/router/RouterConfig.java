package com.reactive.auction.config.router;

import com.reactive.auction.handler.UserHandler;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class RouterConfig {
    private UserHandler userHandler;

    public RouterConfig(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> pageRouter(){
        return RouterFunctions.route(GET("/welcome"), request -> ok().contentType(MediaType.TEXT_HTML).render("welcome.out"))
                .andRoute(GET("/login"), request -> ok().contentType(MediaType.TEXT_HTML).render("login.out"));
    }

    @Bean
    public RouterFunction<ServerResponse> apiRouter(){
        return RouterFunctions.route(GET("/test"), request -> userHandler.test(request));
    }
}
