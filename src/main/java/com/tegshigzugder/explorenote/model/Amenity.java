package com.tegshigzugder.explorenote.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing various amenities.
 */
public enum Amenity {
    BAR("Bar"),
    BIERGARTEN("Biergarten"),
    CAFE("Cafe"),
    FAST_FOOD("Fast_food"),
    FOOD_COURT("Food_court"),
    ICE_CREAM("Ice_cream"),
    PUB("Pub");

    private final String amenityName;

    Amenity(String amenityName) {
        this.amenityName = amenityName;
    }

    @JsonValue
    public String getDisplayName() {
        return amenityName;
    }

    @JsonCreator
    public static Amenity fromValue(String value) {
        for (Amenity amenity : Amenity.values()) {
            if (amenity.amenityName.equalsIgnoreCase(value)) {
                return amenity;
            }
        }
        throw new IllegalArgumentException("Unknown amenity: " + value);
    }
}