package com.lhind.mapper;

import com.lhind.model.dto.BookingDTO;
import com.lhind.model.entity.Booking;

import java.sql.Date;

public class BookingMapper extends AbstractMapper<Booking, BookingDTO>{
    @Override
    public Booking toEntity(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public BookingDTO toDto(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate((Date) booking.getBookingStartDate());
        bookingDTO.setStatus(String.valueOf(booking.getBookingStatus()));
        return bookingDTO;
    }
}

