package com.tegshigzugder.explorenote.model;

import lombok.Data;

@Data
public class PlaceReviewDto {
    private int reviewId;
    private int rating;
    private String comment;
}