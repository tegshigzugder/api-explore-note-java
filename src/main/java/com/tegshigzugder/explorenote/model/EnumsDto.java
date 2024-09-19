package com.tegshigzugder.explorenote.model;

import java.util.List;

public class EnumsDto {
    // @JsonProperty("Amenities")
    private List<String> amenities;

    // @JsonProperty("Cities")
    private List<String> cities;

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}