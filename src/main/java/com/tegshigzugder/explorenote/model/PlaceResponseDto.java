package com.tegshigzugder.explorenote.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaceResponseDto {

    private String name;
    private String amenity;
    private PlaceSource source;
    private long nodeId;
    private double lat;
    private double lon;

    public static List<PlaceResponseDto> convertToPlaceResponseDto(List<Element> elements) {
        return elements.stream().map(element -> {
            PlaceResponseDto dto = new PlaceResponseDto();
            dto.setName(element.getTags().getName());
            dto.setAmenity(element.getTags().getAmenity());
            dto.setSource(PlaceSource.OPEN_STREET_MAP);
            dto.setNodeId(element.getId());
            dto.setLat(element.getLat());
            dto.setLon(element.getLon());
            return dto;
        }).collect(Collectors.toList());
    }
}