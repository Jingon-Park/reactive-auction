package com.reactive.auction.handler;


import com.reactive.auction.domain.ItemInfo;
import com.reactive.auction.repository.ItemInfoRepository;
import com.reactive.auction.service.ItemInfoService;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ItemInfoHandler {

    private ItemInfoService itemInfoService;

    public ItemInfoHandler(ItemInfoService itemInfoService) {

        this.itemInfoService = itemInfoService;
    }

    public Mono<ServerResponse> getItemInfo(ServerRequest request) {
        String name = request.pathVariable("name");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(this.itemInfoService.searchByName(name), ItemInfo.class);
    }

}
