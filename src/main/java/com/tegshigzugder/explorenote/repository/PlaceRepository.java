package com.tegshigzugder.explorenote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tegshigzugder.explorenote.model.database.Place;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNodeId(long nodeId);

    List<Place> findAll();

    // @Query("SELECT p FROM Place p")
    // List<Place> findAllPlaces();
}