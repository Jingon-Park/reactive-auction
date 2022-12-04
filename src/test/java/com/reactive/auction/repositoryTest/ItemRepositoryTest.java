package com.reactive.auction.repositoryTest;

import com.reactive.auction.domain.Item;
import com.reactive.auction.repository.CustomItemRepositoryImpl;
import com.reactive.auction.repository.ItemRepository;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataR2dbcTest
@Slf4j
public class ItemRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(ItemRepositoryTest.class);
    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("Custom Repository 아이템 조회 테스트")
    @Test
    void findAllOrdersWithMemberTest() {
        // given

        // when
        List<Item> items = itemRepository.findAllItemsWithUser()
                .collectList()
                .block();

        // then
        assertNotNull(items);
        items.forEach(order -> System.out.println("items = " + order));

    }
}
