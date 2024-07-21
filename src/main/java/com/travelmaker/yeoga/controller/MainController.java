package com.travelmaker.yeoga.controller;

import com.travelmaker.yeoga.service.TripRecommendationService;
import com.travelmaker.yeoga.dto.TripRecommendationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yeoga")
public class MainController {

    private final TripRecommendationService tripRecommendationService;

    @Autowired
    public MainController(TripRecommendationService tripRecommendationService) {
        this.tripRecommendationService = tripRecommendationService;
    }

    @GetMapping("/main")
    public ResponseEntity<List<TripRecommendationDTO>> getRecommendations(@RequestParam String location) {
        List<TripRecommendationDTO> recommendations = tripRecommendationService.getRecommendations(location);
        return ResponseEntity.ok(recommendations);
    }
}