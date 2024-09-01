package com.choosr.item_picker_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "item_votes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemVote {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "item_id")
    private UUID itemId;
}
