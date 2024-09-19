package com.tegshigzugder.explorenote.model.database;

import java.util.ArrayList;
import java.util.List;

import com.tegshigzugder.explorenote.model.Amenity;

import jakarta.persistence.*;
import lombok.*;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String location;

    private long nodeId;

    @Enumerated(EnumType.STRING)
    private Amenity amenity;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceItem> placeItems = new ArrayList<>();

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceReview> placeReviews = new ArrayList<>();
}