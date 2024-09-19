package com.tegshigzugder.explorenote.model;

import com.tegshigzugder.explorenote.model.database.Place;
import com.tegshigzugder.explorenote.model.database.PlaceItem;
import com.tegshigzugder.explorenote.model.database.PlaceItemReview;
import com.tegshigzugder.explorenote.model.database.PlaceReview;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PlaceDetailsResponseDto {
    private long nodeId;
    private String placeName;
    private String location;
    private Amenity amenity;
    private List<PlaceReviewDto> reviews;
    private List<PlaceItemDto> placeItems;

    public static PlaceDetailsResponseDto convertToPlaceDetailsResponseDto(Place element) {
        PlaceDetailsResponseDto response = new PlaceDetailsResponseDto();
        response.setNodeId(element.getNodeId());
        response.setPlaceName(element.getName());
        response.setAmenity(element.getAmenity());
        response.setLocation(element.getLocation());
        response.setReviews(convertToReviewDtoList(element.getPlaceReviews()));
        response.setPlaceItems(convertToPlaceItemDtoList(element.getPlaceItems()));
        return response;
    }

    private static List<PlaceItemDto> convertToPlaceItemDtoList(List<PlaceItem> placeItems) {
        return placeItems.stream().map(placeItem -> {
            PlaceItemDto dto = new PlaceItemDto();
            dto.setPlaceItemId(placeItem.getId());
            dto.setPlaceItemName(placeItem.getName());
            dto.setPlaceItemPrice(placeItem.getPrice());
            dto.setPlaceItemReviews(convertToPlaceItemReviewDtoList(placeItem.getPlaceItemReviews()));
            return dto;
        }).collect(Collectors.toList());
    }

    private static List<PlaceReviewDto> convertToReviewDtoList(List<PlaceReview> reviews) {
        return reviews.stream().map(review -> {
            PlaceReviewDto dto = new PlaceReviewDto();
            dto.setReviewId(review.getId());
            dto.setRating(review.getRating());
            dto.setComment(review.getComment());
            return dto;
        }).collect(Collectors.toList());
    }

    private static List<PlaceItemReviewDto> convertToPlaceItemReviewDtoList(List<PlaceItemReview> placeItemReviews) {
        return placeItemReviews.stream().map(review -> {
            PlaceItemReviewDto dto = new PlaceItemReviewDto();
            dto.setPlaceItemReviewId(review.getId());
            dto.setRating(review.getRating());
            dto.setComment(review.getComment());
            return dto;
        }).collect(Collectors.toList());
    }
}