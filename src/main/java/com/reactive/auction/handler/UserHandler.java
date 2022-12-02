package com.reactive.auction.handler;

import com.reactive.auction.domain.User;
import com.reactive.auction.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EnableR2dbcRepositories
public class UserHandler {

    Logger log = LoggerFactory.getLogger(UserHandler.class);
    private UserRepository userRepository;

    public UserHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> test(ServerRequest request){
        log.info("test");
        Flux<User> all = userRepository.findAll();
        all.subscribe(data -> {log.info(data.toString());});
        return ServerResponse.ok().build();
    }
}
