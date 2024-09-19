package com.tegshigzugder.explorenote.mapper;

import com.tegshigzugder.explorenote.model.PlaceItemReviewRequestDto;
import com.tegshigzugder.explorenote.model.PlaceReviewRequestDto;
import com.tegshigzugder.explorenote.model.database.Place;
import com.tegshigzugder.explorenote.model.database.PlaceItem;
import com.tegshigzugder.explorenote.model.database.PlaceItemReview;
import com.tegshigzugder.explorenote.model.database.PlaceReview;
import org.springframework.stereotype.Component;

@Component
public class PlaceReviewMapper {

    public Place toPlaceEntity(long placeId, PlaceReviewRequestDto dto) {
        Place place = new Place();
        place.setNodeId(placeId);
        place.setLocation(dto.getLocation());
        place.setName(dto.getName());
        place.setAmenity(dto.getAmenity());
        return place;
    }

    public void toPlaceReviewEntity(PlaceReviewRequestDto dto, Place place) {
        PlaceReview placeReview = new PlaceReview();
        placeReview.setRating(dto.getRating());
        placeReview.setComment(dto.getComment());
        placeReview.setPlace(place);
        
        place.getPlaceReviews().add(placeReview);
    }

    public void toPlaceItemEntities(PlaceReviewRequestDto dto, Place place) {
        for (PlaceItemReviewRequestDto item : dto.getPlaceItemReviews()) {
            PlaceItem placeItem = place.getPlaceItems().stream()
                .filter(p -> p.getName().equals(item.getPlaceItemName()))
                .findFirst()
                .orElse(null);
            if (placeItem == null) {
                placeItem = new PlaceItem();
                placeItem.setName(item.getPlaceItemName());
                placeItem.setPrice(item.getPlaceItemPrice());
                placeItem.setPlace(place);
            }
            PlaceItemReview placeItemReview = new PlaceItemReview();
            placeItemReview.setRating(item.getPlaceItemRating());
            placeItemReview.setComment(item.getPlaceItemComment());
            placeItemReview.setPlaceItem(placeItem);


            placeItem.getPlaceItemReviews().add(placeItemReview);
            place.getPlaceItems().add(placeItem);
        }
    }
}