package com.tegshigzugder.explorenote.model.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlaceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private BigDecimal price;

    @OneToMany(mappedBy = "placeItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceItemReview> placeItemReviews = new ArrayList<>();

    @ManyToOne
    private Place place;
}