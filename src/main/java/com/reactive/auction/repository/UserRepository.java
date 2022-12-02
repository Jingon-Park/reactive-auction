package com.reactive.auction.repository;

import com.reactive.auction.domain.User;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableR2dbcRepositories
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
