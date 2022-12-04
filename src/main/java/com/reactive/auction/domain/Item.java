package com.reactive.auction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table(name = "Items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column("bib_amount")
    Long bidAmount;


}
