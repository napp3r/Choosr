package com.choosr.item_picker_game.service;

import com.choosr.item_picker_game.dto.VotesBatchRequest;
import com.choosr.item_picker_game.model.Item;
import com.choosr.item_picker_game.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void insertVotesBatch(VotesBatchRequest request) {
        itemRepository.insertVotesBatch(request);
    }

    @Override
    public List<Item> getItemsBatch() {
        return itemRepository.getItemBatch();
    }
}
