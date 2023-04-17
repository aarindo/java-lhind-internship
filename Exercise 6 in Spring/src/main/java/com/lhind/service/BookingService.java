package com.lhind.service;

import com.lhind.model.dto.BookingDTO;
import com.lhind.model.entity.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<BookingDTO> loadAllBookings();
    List<BookingDTO> deleteBooking(Booking booking);
    List<BookingDTO> findBookingById(Long id);
    List<BookingDTO> saveNewBooking(Booking booking);
    List<BookingDTO> findByBookingDate(Date bookingDate);
}