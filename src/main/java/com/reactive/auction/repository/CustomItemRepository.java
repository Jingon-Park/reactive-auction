package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomItemRepository {

    Flux<Item> findAllItemsWithUser();

    Mono<Item> findItemWithUser(Long itemId);
}
