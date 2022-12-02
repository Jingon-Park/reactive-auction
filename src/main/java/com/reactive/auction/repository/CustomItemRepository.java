package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import reactor.core.publisher.Flux;

public interface CustomItemRepository {

    Flux<Item> findAllItemsWithUser();
}
