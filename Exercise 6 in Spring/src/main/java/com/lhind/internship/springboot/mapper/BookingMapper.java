package com.lhind.internship.springboot.mapper;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class BookingMapper extends AbstractMapper<Booking, BookingDTO>{

    FlightMapper flightMapper;

    @Override
    public BookingDTO toDto(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setUsername(booking.getUser().getUsername());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setBookingStatus(booking.getBookingStatus());
        List<FlightDTO> flightDTOs = booking.getFlights().stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        bookingDTO.setFlights(flightDTOs);
        return bookingDTO;
    }
}
