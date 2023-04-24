package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.repository.BookingRepository;
import com.lhind.internship.springboot.service.BookingService;
import com.lhind.internship.springboot.service.FlightService;
import com.lhind.internship.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final FlightService flightService;
    private final UserService userService;

    public BookingServiceImpl(BookingRepository bookingRepository, FlightService flightService, UserService userService) {
        this.bookingRepository = bookingRepository;
        this.flightService = flightService;
        this.userService = userService;
    }

    @Override
    public BookingDTO save(Booking booking) {
        return convertToDTO(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDTO> findAll() {
        List<BookingDTO> bookingDTOList = bookingRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());

        return bookingDTOList;
    }

    @Override
    public BookingDTO findById(int id) {
        Booking booking;
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()){
            booking = bookingOptional.get();
            return convertToDTO(booking);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingDate((Date) booking.getBookingStartDate());
        bookingDTO.setBookingStatus(booking.getBookingStatus());
        return bookingDTO;
    }
}
