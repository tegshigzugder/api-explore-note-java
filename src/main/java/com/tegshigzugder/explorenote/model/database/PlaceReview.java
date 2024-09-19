package com.tegshigzugder.explorenote.model.database;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlaceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rating;
    private String comment;

    @ManyToOne
    private Place place;

    // TODO: Implement place having multiple photos
    // private List<Photo> photos;
}