package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.UserDTO;
import com.lhind.internship.springboot.model.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(Integer id, User uptatedUser);
    List<UserDTO> findAll();
    List<BookingDTO> findAllBookings(Integer id);
    BookingDTO findBookingByIdAndUser(Integer bookingId, Integer id);
    User findById(Integer id);
    void delete(Integer id);

}
