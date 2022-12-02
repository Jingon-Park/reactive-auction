package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, Long>, CustomItemRepository {
}
