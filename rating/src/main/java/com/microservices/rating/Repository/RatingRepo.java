package com.microservices.rating.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.rating.Entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {

}
