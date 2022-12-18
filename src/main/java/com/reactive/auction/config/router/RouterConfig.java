package com.reactive.auction.config.router;

import com.reactive.auction.handler.ItemHandler;
import com.reactive.auction.handler.ItemInfoHandler;
import com.reactive.auction.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class RouterConfig {
    private UserHandler userHandler;
    private ItemHandler itemHandler;
    private ItemInfoHandler itemInfoHandler;

    public RouterConfig(UserHandler userHandler, ItemHandler itemHandler, ItemInfoHandler itemInfoHandler) {

        this.userHandler = userHandler;
        this.itemHandler = itemHandler;
        this.itemInfoHandler = itemInfoHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> pageRouter(){
        return RouterFunctions.route(GET("/welcome"), request -> ok().contentType(MediaType.TEXT_HTML).render("welcome.out"))
                .andRoute(GET("/login"), request -> ok().contentType(MediaType.TEXT_HTML).render("login.out"));
    }

    @Bean
    public RouterFunction<ServerResponse> apiRouter(){
        return RouterFunctions.route(GET("/users"), userHandler::getUsers)
                .andRoute(GET("/items"), itemHandler::getItems)
                .andRoute(GET("/item/{itemId}"), itemHandler::getItem)
                .andRoute(POST("/item"), itemHandler::addItem)
                .andRoute(GET("itemInfo/{name}"), itemInfoHandler::getItemInfo)
                .andRoute(GET("item/category/{name}"), itemHandler::getItemByCategory);
    }
}
