package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.mapper.BookingMapper;
import com.lhind.internship.springboot.mapper.FlightMapper;
import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.model.entity.Flight;
import com.lhind.internship.springboot.repository.BookingRepository;
import com.lhind.internship.springboot.repository.FlightRepository;
import com.lhind.internship.springboot.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private FlightRepository flightRepository;
    private BookingMapper bookingMapper;
    private FlightMapper flightMapper;

    @Override
    public Booking save(Booking booking) {
        Booking bookingNew = new Booking();
        bookingNew.setUser(booking.getUser());
        bookingNew.setBookingDate(booking.getBookingDate());
        bookingNew.setBookingStatus(booking.getBookingStatus());
        bookingNew.setFlights(booking.getFlights());
        bookingNew = bookingRepository.save(bookingNew);
        return bookingNew;
    }

    @Override
    public List<BookingDTO> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Booking> findById(Integer id){
        return bookingRepository.findById(id);
    }

    @Override
    public List<FlightDTO> findAllFlights(Integer id) {
        List<Flight> flights = flightRepository.findFlightByBookings(bookingRepository.findById(id).get());
        return flights.stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Booking u){
        bookingRepository.delete(u);
    }
}
