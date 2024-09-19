package com.tegshigzugder.explorenote.service;

import com.tegshigzugder.explorenote.model.Amenity;
import com.tegshigzugder.explorenote.model.City;
import com.tegshigzugder.explorenote.model.PlaceResponseDto;
import com.tegshigzugder.explorenote.model.PlaceSource;
import com.tegshigzugder.explorenote.provider.OsmOverpassProvider;
import com.tegshigzugder.explorenote.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PlaceService {

    @Autowired
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public CompletableFuture<ResponseEntity<List<PlaceResponseDto>>> search(City city, Amenity amenity,
            PlaceSource source) {
        // TODO implement search method
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    public CompletableFuture<List<PlaceResponseDto>> getPlacesOfInterest(City city, Amenity amenity) {
        return OsmOverpassProvider.onGetSearchText(city, amenity)
                .thenApply(
                        overpassResponse -> PlaceResponseDto.convertToPlaceResponseDto(overpassResponse.getElements()));
    }

    public void getPlaceByNodeId(long nodeId) {
        var result = placeRepository.findByNodeId(nodeId);
        if (result == null) {
            throw new IllegalArgumentException("Place not found");
        }
    }
}
