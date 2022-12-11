package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import com.reactive.auction.repository.mapper.ItemMapper;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository {

    private final DatabaseClient client;
    private ItemMapper mapper = new ItemMapper();

    private final String itemJoinQuery = "SELECT "+
            "Users.user_id, Users.nick_name, Users.email,"+
            "item_id, title, description, start_time, end_time, bid_user_id, bid_price, start_price, sell_price, status, title_img "+
            "FROM Items "+
            "INNER JOIN Users ";

    @Override
    public Flux<Item> findAllItemsWithUser() {
        String query = itemJoinQuery +
                "ON Items.user_id = Users.user_id";

        return client.sql(query)
                .map(mapper::apply)
                .all();
    }

    @Override
    public Mono<Item> findItemWithUser(Long itemId) {
        String query = itemJoinQuery +
                "ON Items.user_id = Users.user_id " +
                "WHERE Items.item_id = " + itemId;
        return client.sql(query)
                .map(mapper::apply)
                .one();
    }
}
