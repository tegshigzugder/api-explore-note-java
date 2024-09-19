package com.tegshigzugder.explorenote.controller;

import com.tegshigzugder.explorenote.model.PlaceDetailsResponseDto;
import com.tegshigzugder.explorenote.model.PlaceReviewRequestDto;
import com.tegshigzugder.explorenote.service.PlaceService;
import com.tegshigzugder.explorenote.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    private final ReviewService reviewService;
    private final PlaceService placeService;

    @Autowired
    public ReviewController(ReviewService reviewService, PlaceService placeService) {
        this.reviewService = reviewService;
        this.placeService = placeService;
    }

    @PostMapping("/addreview/{userId}/{placeId}")
    public ResponseEntity<Void> addReview(@PathVariable int userId, @PathVariable long placeId,
            @RequestBody PlaceReviewRequestDto placeRequestDto) {
        reviewService.addReview(userId, placeId, placeRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getreview/{userId}/{placeId}")
    public ResponseEntity<List<PlaceDetailsResponseDto>> addReview(@PathVariable int userId, @PathVariable long placeId) {
        var result = reviewService.getReview(userId, placeId);
        return ResponseEntity.ok(result);
    }
}