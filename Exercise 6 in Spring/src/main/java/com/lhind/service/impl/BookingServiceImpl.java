package com.lhind.service.impl;

import com.lhind.mapper.BookingMapper;
import com.lhind.model.dto.BookingDTO;
import com.lhind.model.entity.Booking;
import com.lhind.repository.impl.BookingRepositoryImpl;
import com.lhind.service.BookingService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingRepositoryImpl bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl() {
        this.bookingMapper = new BookingMapper();
        this.bookingRepository = new BookingRepositoryImpl();
    }

    @Override
    public List<BookingDTO> loadAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> deleteBooking(Booking booking) {
        return null;
    }

    @Override
    public List<BookingDTO> findBookingById(Long id) {
        return null;
    }

    @Override
    public List<BookingDTO> saveNewBooking(Booking booking) {
        return null;
    }

    @Override
    public List<BookingDTO> findByBookingDate(Date bookingDate) {
        return null;
    }

}
