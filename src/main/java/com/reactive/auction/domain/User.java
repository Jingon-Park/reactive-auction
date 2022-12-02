package com.reactive.auction.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "Users")
@Getter
@Builder
public class User {

    @Id
    @Column("user_id")
    Long userId;

    @Column("nick_name")
    String nickName;
    @Column("email")
    String email;
    @Column("social_type")
    Integer socialType;

}
