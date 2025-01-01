package com.microservices.rating.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.rating.Entities.Rating;

public interface RatingService {
    public Rating CreateRating(@RequestBody Rating rating);

    public Rating getRating(@PathVariable String ratingId);

    public List<Rating> GetAllRating();

    public Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);

    public void DeleteRating(@PathVariable String ratingId);
}
