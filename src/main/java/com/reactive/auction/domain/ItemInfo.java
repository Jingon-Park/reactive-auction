package com.reactive.auction.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "Item_Info")
@NoArgsConstructor
public class ItemInfo {

    @Id
    @Column("item_info_id")
    Long itemInfoId;

    @Column("item_id")
    Long itemId;

    @Column("category_name")
    String categoryName;
}
