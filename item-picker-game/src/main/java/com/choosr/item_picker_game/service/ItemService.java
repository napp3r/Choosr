package com.choosr.item_picker_game.service;

import com.choosr.item_picker_game.dto.VotesBatchRequest;
import com.choosr.item_picker_game.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getItems();

    void insertVotesBatch(VotesBatchRequest request);

    List<Item> getItemsBatch();
}
