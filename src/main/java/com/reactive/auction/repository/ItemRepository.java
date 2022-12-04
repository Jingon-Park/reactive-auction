package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, Long>, CustomItemRepository {
}
