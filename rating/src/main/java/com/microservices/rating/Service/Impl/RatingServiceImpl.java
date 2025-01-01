package com.microservices.rating.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.rating.Entities.Rating;
import com.microservices.rating.Exception.ResourceNotFound;
import com.microservices.rating.Repository.RatingRepo;
import com.microservices.rating.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating CreateRating(Rating rating) {
        Rating save = ratingRepo.save(rating);
        return save;
    }

    @Override
    public Rating getRating(String ratingId) {
        Rating rating = ratingRepo.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFound("Rating is not found for given Id"));
        return rating;
    }

    @Override
    public List<Rating> GetAllRating() {
        List<Rating> ratings = ratingRepo.findAll();
        return ratings;
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {
        Rating rating2 = ratingRepo.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFound("Rating is not found for given Id"));
        rating2.setFeedback(rating.getFeedback());
        rating2.setRating(rating.getRating());
        rating2.setHotelId(rating.getHotelId());
        rating2.setUserId(rating.getUserId());
        Rating save = ratingRepo.save(rating2);
        return save;
    }

    @Override
    public void DeleteRating(String ratingId) {
        Rating rating = ratingRepo.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFound("Rating is not found for given Id"));
        ratingRepo.delete(rating);
    }

}
