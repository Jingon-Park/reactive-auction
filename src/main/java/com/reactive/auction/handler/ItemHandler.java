package com.reactive.auction.handler;

import com.reactive.auction.domain.Item;
import com.reactive.auction.domain.ItemInfo;
import com.reactive.auction.service.ItemInfoService;
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
    private ItemInfoService itemInfoService;

    public ItemHandler(ItemService itemService, ItemInfoService itemInfoService) {
        this.itemService = itemService;
        this.itemInfoService = itemInfoService;
    }

    public Mono<ServerResponse> getItems(ServerRequest request) {
        Flux<Item> allItems = itemService.findAllItems();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allItems, Item.class);
    }

    public Mono<ServerResponse> addItem(ServerRequest request) {

        return request.bodyToMono(Item.class)
                .flatMap(data -> {
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(itemService.addItem(data), Item.class);
                });
    }

    public Mono<ServerResponse> getItem(ServerRequest request) {

        Long itemId = Long.parseLong(request.pathVariable("itemId"));
        Mono<Item> item = itemService.findItem(itemId);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(item, Item.class);

    }

    public Mono<ServerResponse> getItemByCategory(ServerRequest request) {

        String name = request.pathVariable("name");
        Flux<ItemInfo> itemInfo = itemInfoService.searchByName(name);

        Flux<Item> items = itemInfo.flatMap(data -> {
            return itemService.findItem(data.getItemId());
        });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(items, Item.class);

    }

}
