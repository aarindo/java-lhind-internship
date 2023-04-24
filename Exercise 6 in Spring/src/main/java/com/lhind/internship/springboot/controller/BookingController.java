package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDTO> findAll(){
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public BookingDTO findById(@PathVariable(name = "id") int id){
        BookingDTO bookingDTO = bookingService.findById(id);
        if (bookingDTO != null){
            return bookingDTO;
        }
        else {
            throw new ResponseStatusException(HttpStatus.resolve(404), "Booking not found");
        }
    }

    @PostMapping
    public BookingDTO save(@RequestBody Booking booking){
        return bookingService.save(booking);
    }

    @PutMapping
    public BookingDTO put(@RequestBody Booking booking){
        return bookingService.save(booking);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable(name = "id") int id){
        try {
            bookingService.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
