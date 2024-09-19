package com.tegshigzugder.explorenote.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing various sources.
 */
public enum PlaceSource {
    OPEN_STREET_MAP("OpenStreetMap"),
    GOOGLE_MAPS("Google Maps");
    
    
    private final String placeSourceName;
    
    PlaceSource(String placeSourceName) {
        this.placeSourceName = placeSourceName;
    }

    @JsonValue
    public String getDisplayName() {
        return placeSourceName;
    }

    @JsonCreator
    public static PlaceSource fromValue(String value) {
        for (PlaceSource placeSource : PlaceSource.values()) {
            if (placeSource.placeSourceName.equalsIgnoreCase(value)) {
                return placeSource;
            }
        }
        throw new IllegalArgumentException("Unknown place source: " + value);
    }
}