package com.reactive.auction.service;

import com.reactive.auction.domain.User;
import com.reactive.auction.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findAllUsers(){
        return userRepository.findAll();
    }

}
