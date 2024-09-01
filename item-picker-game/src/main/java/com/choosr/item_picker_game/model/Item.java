package com.choosr.item_picker_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "creation_date", updatable = false)
    private LocalDate creationDate;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "description")
    private String description;

    // Getters and Setters

}

