package com.choosr.item_picker_game.controller;

import com.choosr.item_picker_game.ItemPickerGameApplication;
import com.choosr.item_picker_game.dto.VotesBatchRequest;
import com.choosr.item_picker_game.model.Item;
import com.choosr.item_picker_game.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gameplay")
@RequiredArgsConstructor
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemPickerGameApplication.class);

    private final ItemService itemService;

    @PostMapping("/batch")
    public void insertVotesBatch(@RequestBody(required = true) VotesBatchRequest request){
        logger.info("the batch: " + request);
        itemService.insertVotesBatch(request);
    }

    @GetMapping("/")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/batch")
    public List<Item> getItemsBatch(){
        return itemService.getItemsBatch();
    }
}
