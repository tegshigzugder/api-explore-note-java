package com.tegshigzugder.explorenote.model;

import java.math.BigDecimal;

public class PlaceItemReviewRequestDto {
    private String placeItemName;
    private BigDecimal placeItemPrice;
    private int placeItemRating;
    private String placeItemComment;

    public String getPlaceItemName() {
        return placeItemName;
    }

    public void setPlaceItemName(String placeItemName) {
        this.placeItemName = placeItemName;
    }

    public BigDecimal getPlaceItemPrice() {
        return placeItemPrice;
    }

    public void setPlaceItemPrice(BigDecimal placeItemPrice) {
        this.placeItemPrice = placeItemPrice;
    }

    public int getPlaceItemRating() {
        return placeItemRating;
    }

    public void setPlaceItemRating(int placeItemRating) {
        this.placeItemRating = placeItemRating;
    }

    public String getPlaceItemComment() {
        return placeItemComment;
    }

    public void setPlaceItemComment(String placeItemComment) {
        this.placeItemComment = placeItemComment;
    }
}