package com.tegshigzugder.explorenote.provider;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tegshigzugder.explorenote.model.Amenity;
import com.tegshigzugder.explorenote.model.City;
import com.tegshigzugder.explorenote.model.OverpassResponse;

public class OsmOverpassProvider {

    private static final String URL = "https://overpass-api.de/api/interpreter";
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static CompletableFuture<OverpassResponse> onGetSearchText(City city, Amenity amenity) {
        HttpClient client = HttpClient.newHttpClient();

        // TODO: transform geocodeArea into area id
        // Leipzig-Center is 3606273540
        // long something = 3606273540;

        String temp = amenity.name().toLowerCase();

        String query = String.format(
                "[out:json][timeout:25];" +
                        "area(id:3606273540)->.searchArea;" +
                        "node[amenity=%s](area.searchArea);" +
                        "out geom;",
                // id, temp);
                temp);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(query))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        try {
                            return objectMapper.readValue(response.body(), OverpassResponse.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.err.println("Error: " + response.statusCode() + " - " + response.body());
                    }
                    return new OverpassResponse();
                });
    }
}