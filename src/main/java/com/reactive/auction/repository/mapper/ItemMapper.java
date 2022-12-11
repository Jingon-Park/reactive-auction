package com.reactive.auction.repository.mapper;

import com.reactive.auction.domain.Item;
import com.reactive.auction.domain.User;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;


public class ItemMapper implements BiFunction<Row, RowMetadata, Item> {

    @Override
    public Item apply(Row row, RowMetadata rowMetadata) {
        return Item.builder()
                .itemId(row.get("item_id", Long.class))
                .title(row.get("title", String.class))
                .description(row.get("description", String.class))
                .startPrice(row.get("start_price", Long.class))
                .sellPrice(row.get("sell_price", Long.class))
                .status(row.get("status", Integer.class))
                .titleImg(row.get("title_img", String.class))
                .user(User.builder()
                        .userId(row.get("user_id", Long.class))
                        .nickName(row.get("nick_name", String.class))
                        .email(row.get("email", String.class))
                        .build())
                .build();
    }
}
