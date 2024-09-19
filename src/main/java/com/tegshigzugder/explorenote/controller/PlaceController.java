package com.tegshigzugder.explorenote.controller;

import java.util.concurrent.CompletableFuture;

import com.tegshigzugder.explorenote.model.Amenity;
import com.tegshigzugder.explorenote.model.City;
import com.tegshigzugder.explorenote.model.EnumsDto;
import com.tegshigzugder.explorenote.service.EnumService;
import com.tegshigzugder.explorenote.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaceController {

    private final PlaceService placeService;
    private final EnumService enumService;

    @Autowired
    public PlaceController(PlaceService placeService, EnumService enumService) {
        this.placeService = placeService;
        this.enumService = enumService;
    }

    @GetMapping("/enums")
    @Operation(summary = "Get all enums", description = "more description")
    public ResponseEntity<EnumsDto> getEnums() {
        EnumsDto enumsDto = new EnumsDto();
        enumsDto.setAmenities(enumService.getAmenities());
        enumsDto.setCities(enumService.getCities());
        return ResponseEntity.ok(enumsDto);
    }

    @GetMapping("/places")
    public CompletableFuture<Object> getPlaces(
            @RequestParam City city,
            @RequestParam Amenity amenity) {
        return placeService.getPlacesOfInterest(city, amenity)
                .thenApply(ResponseEntity::ok);
    }
}