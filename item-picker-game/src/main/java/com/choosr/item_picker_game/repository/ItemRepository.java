package com.choosr.item_picker_game.repository;

import com.choosr.item_picker_game.dto.VotesBatchRequest;
import com.choosr.item_picker_game.model.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Query(value = "SELECT * FROM items ORDER BY RANDOM() LIMIT 6", nativeQuery = true)
    List<Item> getItemBatch();

    @Modifying
    @Query(value = "INSERT INTO item_votes (item_id) VALUES (:voteId)", nativeQuery = true)
    void insertVote(UUID voteId);

    @Transactional
    default void insertVotesBatch(VotesBatchRequest request) {
        request.votesBatch().forEach(this::insertVote);
    }
}
