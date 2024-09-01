package com.choosr.item_picker_game.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public record VotesBatchRequest (
        List<UUID> votesBatch
) {
}
