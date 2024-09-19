package com.tegshigzugder.explorenote.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tegshigzugder.explorenote.model.Amenity;
import com.tegshigzugder.explorenote.model.City;
import org.springframework.stereotype.Service;

/**
 * Service class to handle operations related to enums.
 */
@Service
public class EnumService {

    /**
     * Retrieves the names of all amenities.
     *
     * @return a list of strings representing the names of all amenities.
     */
    public List<String> getAmenities() {
        return Arrays.stream(Amenity.values())
                .map(Amenity::getDisplayName)
                // .map(this::capitalize)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the names of all cities.
     *
     * @return a list of strings representing the names of all cities.
     */
    public List<String> getCities() {
        return Arrays.stream(City.values())
                .map(City::getDisplayName)
                // .map(this::capitalize)
                .collect(Collectors.toList());
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}