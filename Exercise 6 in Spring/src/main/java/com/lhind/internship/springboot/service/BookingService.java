package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    public Booking save(Booking booking);
    public List<BookingDTO> findAll();
    Optional<Booking> findById(Integer id);
    List<FlightDTO> findAllFlights(Integer id);
    void delete(Booking user);

}
