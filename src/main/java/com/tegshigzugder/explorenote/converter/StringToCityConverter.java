package com.tegshigzugder.explorenote.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tegshigzugder.explorenote.model.City;

@Component
public class StringToCityConverter implements Converter<String, City> {

    @Override
    public City convert(String source) {
        for (City city : City.values()) {
            if (city.getDisplayName().equalsIgnoreCase(source)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Invalid city: " + source);
    }
}