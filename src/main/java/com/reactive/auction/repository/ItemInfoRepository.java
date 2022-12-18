package com.reactive.auction.repository;

import com.reactive.auction.domain.ItemInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemInfoRepository extends ReactiveCrudRepository<ItemInfo, Long> {


    @Query("select * from Item_Info where category_name = :name")
    Flux<ItemInfo> findByName(String name);

}
