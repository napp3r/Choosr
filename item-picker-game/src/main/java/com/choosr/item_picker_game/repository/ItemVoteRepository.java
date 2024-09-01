package com.choosr.item_picker_game.repository;

import com.choosr.item_picker_game.model.ItemVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemVoteRepository extends JpaRepository<ItemVote, UUID> {

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO item_votes(item_id) " +
//            "SELECT uuid, CURRENT_DATE " +
//            "FROM (VALUES " +
//            "(:uuidList)) AS v(uuid)", nativeQuery = true)
//    void InsertItemVotes(VotesBatchRequest request);

}
