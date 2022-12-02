package com.reactive.auction.repository;

import com.reactive.auction.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import com.reactive.auction.repository.mapper.ItemMapper;

@Repository
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository{

    private final DatabaseClient client;
    private ItemMapper mapper = new ItemMapper();

    @Override
    public Flux<Item> findAllItemsWithUser() {
        String query = "SELECT " +
                "Users.user_id, Users.nick_name, Users.email," +
                "item_id, title, description, start_time, end_time, bib_user_id, bib_amount " +
                "FROM Items " +
                "INNER JOIN Users " +
                "ON Items.user_id = Users.user_id";

        return client.sql(query)
                .map(mapper::apply)
                .all();
    }
}
