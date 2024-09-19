package com.tegshigzugder.explorenote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags {
    @JsonProperty("addr:city")
    private String addrCity;

    @JsonProperty("addr:country")
    private String addrCountry;

    @JsonProperty("addr:district")
    private String addrDistrict;

    @JsonProperty("addr:full")
    private String addrFull;

    @JsonProperty("addr:hamlet")
    private String addrHamlet;

    @JsonProperty("addr:housenumber")
    private String addrHousenumber;

    @JsonProperty("addr:neighbourhood")
    private String addrNeighbourhood;

    @JsonProperty("addr:place")
    private String addrPlace;

    @JsonProperty("addr:postcode")
    private String addrPostcode;

    @JsonProperty("addr:state")
    private String addrState;

    @JsonProperty("addr:street")
    private String addrStreet;

    @JsonProperty("addr:TW:dataset")
    private String addrTW_Dataset;

    private String amenity;
    private String barrier;

    @JsonProperty("created_by")
    private String createdBy;

    private String crossing;
    private String highway;
    private String name;
    private String natural;
    private String operator;
    private String place;
    private String power;
    private String source;

    @JsonProperty("source:date")
    private String sourceDate;

    public String getName() {
        return name;
    }

    public String getAmenity() {
        return amenity;
    }
}