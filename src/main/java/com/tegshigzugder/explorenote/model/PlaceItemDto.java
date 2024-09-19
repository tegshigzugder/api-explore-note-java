package com.tegshigzugder.explorenote.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PlaceItemDto {
    private int placeItemId;
    private String placeItemName;
    private BigDecimal placeItemPrice;
    private List<PlaceItemReviewDto> placeItemReviews;
}