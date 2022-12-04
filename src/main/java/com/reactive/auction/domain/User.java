package com.reactive.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "Users")
@Getter
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {
    }
}
