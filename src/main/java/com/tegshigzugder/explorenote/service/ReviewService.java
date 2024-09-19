package com.tegshigzugder.explorenote.service;

import com.tegshigzugder.explorenote.mapper.PlaceReviewMapper;
import com.tegshigzugder.explorenote.model.PlaceDetailsResponseDto;
import com.tegshigzugder.explorenote.model.PlaceReviewRequestDto;
import com.tegshigzugder.explorenote.model.database.Place;
import com.tegshigzugder.explorenote.repository.PlaceRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private final PlaceRepository placeRepository;

    @Autowired
    private final PlaceReviewMapper placeReviewMapper;

    public ReviewService(PlaceRepository placeRepository, PlaceReviewMapper placeReviewMapper) {    
        this.placeRepository = placeRepository;
        this.placeReviewMapper = placeReviewMapper;
    }

    @Transactional
    public void addReview(int userId, long placeId, PlaceReviewRequestDto placeRequestDto) {
        Place place = placeRepository.findByNodeId(placeId);
        if (place == null) {
            place = placeReviewMapper.toPlaceEntity(placeId, placeRequestDto);
        }

        placeReviewMapper.toPlaceReviewEntity(placeRequestDto, place);
        placeReviewMapper.toPlaceItemEntities(placeRequestDto, place);

        placeRepository.save(place);
    }

    public List<PlaceDetailsResponseDto> getReview(int userId, long placeId) {
        return placeRepository.findAll().stream()
            .map(PlaceDetailsResponseDto::convertToPlaceDetailsResponseDto)
            .collect(Collectors.toList());
    }
}