package com.reactive.auction.service;


import com.reactive.auction.domain.Item;
import com.reactive.auction.repository.ItemRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Flux<Item> findAllItems() {
        return this.itemRepository.findAllItemsWithUser();
    }

    public Mono<Item> addItem(Item item) {
        return itemRepository.save(item);
    }

    public Mono<Item> findItem(Long itemId) {
        return itemRepository.findItemWithUser(itemId);
    }
}
