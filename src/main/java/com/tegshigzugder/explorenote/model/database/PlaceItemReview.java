package com.tegshigzugder.explorenote.model.database;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place_item_review")
public class PlaceItemReview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rating;
    private String comment;

    @ManyToOne
    private PlaceItem placeItem;

    // TODO: Implement place having multiple photos
    // private List<Photo> photos;
}