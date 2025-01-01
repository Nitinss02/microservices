package com.microservice.hotelservice.Service;

import java.util.List;

import com.microservice.hotelservice.Entities.Hotel;

public interface HotelService {
    public Hotel saveHotel(Hotel hotel);

    public Hotel getHotelById(String hotelId);

    public List<Hotel> getAllHotels();

    public Hotel updateHotel(Hotel hotel, String hotelId);

    public void deleteHotel(String hotelId);
}
