package com.microservices.rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rating.Entities.Rating;
import com.microservices.rating.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> CreateRating(@RequestBody Rating rating) {
        Rating createRating = ratingService.CreateRating(rating);
        return new ResponseEntity<>(createRating, HttpStatus.CREATED);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(String ratingId) {
        Rating rating = ratingService.getRating(ratingId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> GetAllRating() {
        List<Rating> allRating = ratingService.GetAllRating();
        return new ResponseEntity<>(allRating, HttpStatus.OK);
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating rating) {
        Rating updateRating = ratingService.updateRating(ratingId, rating);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> DeleteRating(@PathVariable String ratingId) {
        ratingService.DeleteRating(ratingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
