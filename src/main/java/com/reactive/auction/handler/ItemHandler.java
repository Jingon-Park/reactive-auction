package com.reactive.auction.handler;

import com.reactive.auction.domain.Item;
import com.reactive.auction.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ItemHandler {

    private final Logger log = LoggerFactory.getLogger(ItemHandler.class);
    private ItemService itemService;

    public ItemHandler(ItemService itemService) {
        this.itemService = itemService;
    }

    public Mono<ServerResponse> findItems(ServerRequest request) {
        Flux<Item> allItems = itemService.findAllItems();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allItems, Item.class);
    }

    public Mono<ServerResponse> addItem(ServerRequest request) {

        return request.bodyToMono(Item.class)
                .flatMap(data -> {
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(itemService.addItem(data), Item.class);
                });
    }

}
