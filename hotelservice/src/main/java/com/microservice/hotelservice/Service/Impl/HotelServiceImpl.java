package com.microservice.hotelservice.Service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotelservice.Entities.Hotel;
import com.microservice.hotelservice.Exception.ResourceNotFound;
import com.microservice.hotelservice.Repository.HotelRepository;
import com.microservice.hotelservice.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        Hotel savedHotel = hotelRepository.save(hotel);
        return savedHotel;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFound("Hotel not found"));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> allhotel = hotelRepository.findAll();
        return allhotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String hotelId) {
        Hotel newhotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFound("Hotel not found"));
        newhotel.setHotelName(hotel.getHotelName());
        newhotel.setLocation(hotel.getLocation());
        newhotel.setAbout(hotel.getAbout());
        Hotel updatedHotel = hotelRepository.save(newhotel);
        return updatedHotel;
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFound("Hotel is not found"));
        hotelRepository.delete(hotel);
    }

}
