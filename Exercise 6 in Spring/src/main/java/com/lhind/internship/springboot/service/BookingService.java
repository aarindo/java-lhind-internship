package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookingService {
    public BookingDTO save(Booking booking);

    public List<BookingDTO> findAll();

    public BookingDTO findById(int id);

    public void delete(int id);

    public BookingDTO convertToDTO(Booking booking);
}
