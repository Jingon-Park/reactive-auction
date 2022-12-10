package com.reactive.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table(name = "Items")
@Data
@Builder
@JsonDeserialize(builder = Item.ItemBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @Id
    @Column("item_id")
    Long itemId;

    @Column("title")
    String title;

    @Column("description")
    String description;

    @Column("start_time")
    Date startTime;
    @Column("end_time")
    Date endTime;

    @Transient
    User user;

    @Column("bib_user_ud")
    Long bibUserId;

    @Column("bib_price")
    Long bidAmount;

    @Column("start_price")
    Long startPrice;

    @Column("sell_price")
    Long sellPrice;

    @Column("status")
    Integer status;



    @JsonPOJOBuilder(withPrefix = "")
    public static class ItemBuilder {
    }

}
