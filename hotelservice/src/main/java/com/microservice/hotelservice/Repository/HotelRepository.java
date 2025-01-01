package com.microservice.hotelservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.hotelservice.Entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
