package com.reactive.auction.handler;

import com.reactive.auction.domain.User;
import com.reactive.auction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EnableR2dbcRepositories
public class UserHandler {

    Logger log = LoggerFactory.getLogger(UserHandler.class);

    private UserService userService;
    public UserHandler(UserService userService){
        this.userService = userService;
    }

    public Mono<ServerResponse> getUsers(ServerRequest request){

        Flux<User> allUsers = userService.findAllUsers();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUsers, User.class);
    }
}
