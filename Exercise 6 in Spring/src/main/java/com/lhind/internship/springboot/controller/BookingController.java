package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.mapper.BookingMapper;
import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.service.BookingService;
import com.lhind.internship.springboot.service.UserService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
@Schema
public class BookingController {
    BookingService bookingService;
    UserService userService;
    BookingMapper bookingMapper;

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BookingDTO>> get() {
        List<BookingDTO> bookings = bookingService.findAll();
        Collections.sort(bookings, Comparator.comparing(BookingDTO::getBookingDate));
        return ResponseEntity.ok(bookings);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/{userId}")
    public ResponseEntity<BookingDTO> getBookingOfUser(@PathVariable Integer id, @PathVariable Integer userId){
        BookingDTO booking = userService.findBookingByIdAndUser(id , userId);
        return ResponseEntity.ok(booking);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
    public ResponseEntity<List<BookingDTO>> getAllBookingOfUser(@PathVariable Integer id) {
        List<BookingDTO> bookingDTOS = userService.findAllBookings(id);
        return ResponseEntity.ok(bookingDTOS);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET ,value = "/{id}/flights")
    public List<FlightDTO> getFlightsFromBooking(@PathVariable(name = "id") Integer id){
        Optional<Booking> bookingOptional = bookingService.findById(id);

        bookingOptional.ifPresent(booking -> bookingService.findById(id));

        List<FlightDTO> flightDtoList = bookingService.findAllFlights(id);
        return flightDtoList;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public BookingDTO saveBooking(@RequestBody Booking booking) {
        bookingService.save(booking);
        return bookingMapper.toDto(booking);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method =RequestMethod.DELETE, value = "/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        Optional<Booking> bookingOptional = bookingService.findById(id);
        bookingOptional.ifPresent(booking -> bookingService.delete(booking));
    }
}
