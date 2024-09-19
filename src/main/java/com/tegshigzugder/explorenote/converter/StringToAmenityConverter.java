package com.tegshigzugder.explorenote.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tegshigzugder.explorenote.model.Amenity;

@Component
public class StringToAmenityConverter implements Converter<String, Amenity> {

    @Override
    public Amenity convert(String source) {
        for (Amenity amenity : Amenity.values()) {
            if (amenity.getDisplayName().equalsIgnoreCase(source)) {
                return amenity;
            }
        }
        throw new IllegalArgumentException("Invalid amenity: " + source);
    }
}