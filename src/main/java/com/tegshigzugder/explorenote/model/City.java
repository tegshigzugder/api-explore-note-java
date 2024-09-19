package com.tegshigzugder.explorenote.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing various cities.
 */
public enum City {
    BERLIN("Berlin"),
    HAMBURG("Hamburg"),
    MUNICH("Munich"),
    COLOGNE("Cologne"),
    FRANKFURT("Frankfurt"),
    STUTTGART("Stuttgart"),
    DUSSELDORF("Düsseldorf"),
    DORTMUND("Dortmund"),
    ESSEN("Essen"),
    LEIPZIG("Leipzig"),
    BREMEN("Bremen"),
    DRESDEN("Dresden");

    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    @JsonValue
    public String getDisplayName() {
        return cityName;
    }

    @JsonCreator
    public static City fromValue(String value) {
        for (City city : City.values()) {
            if (city.cityName.equalsIgnoreCase(value)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Unknown city: " + value);
    }
}