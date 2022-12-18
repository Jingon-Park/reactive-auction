package com.reactive.auction.service;

import com.reactive.auction.domain.ItemInfo;
import com.reactive.auction.repository.ItemInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemInfoService {

    private ItemInfoRepository itemInfoRepository;

    public ItemInfoService(ItemInfoRepository itemInfoRepository) {
        this.itemInfoRepository = itemInfoRepository;
    }

    public Mono<ItemInfo> searchById(Long id) {
        return this.itemInfoRepository.findById(id);
    }

    public Flux<ItemInfo> searchByName(String name) {
        return this.itemInfoRepository.findByName(name);
    }
}
