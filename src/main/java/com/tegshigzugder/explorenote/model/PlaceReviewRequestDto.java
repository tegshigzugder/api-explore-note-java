package com.tegshigzugder.explorenote.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceReviewRequestDto {
    private String location;
    private String name;
    private Amenity amenity;
    private int rating;
    private String comment;
    private List<PlaceItemReviewRequestDto> placeItemReviews;
}