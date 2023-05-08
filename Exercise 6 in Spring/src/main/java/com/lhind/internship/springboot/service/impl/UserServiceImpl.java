package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.mapper.BookingMapper;
import com.lhind.internship.springboot.mapper.UserMapper;
import com.lhind.internship.springboot.model.dto.BookingDTO;
import com.lhind.internship.springboot.model.dto.UserDTO;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.model.entity.User;
import com.lhind.internship.springboot.model.entity.UserDetail;
import com.lhind.internship.springboot.repository.BookingRepository;
import com.lhind.internship.springboot.repository.UserDetailRepository;
import com.lhind.internship.springboot.repository.UserRepository;
import com.lhind.internship.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDetailRepository userDetailRepository;
    private BookingRepository bookingRepository;
    private UserMapper userMapper;
    private BookingMapper bookingMapper;
    @Override
    public User save(User user) {
        User userN = new User();
        BeanUtils.copyProperties(user, userN);

        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(user.getUserDetail(), userDetail, "userDetail");
        userDetail.setUser(userN);

        userN.setUserDetail(userDetail);
        userRepository.save(userN);
        userDetailRepository.save(userDetail);

        return userN;
    }

    @Override
    public User update(Integer id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    BeanUtils.copyProperties(updatedUser, user, "id", "userDetail");
                    BeanUtils.copyProperties(updatedUser.getUserDetail(), user.getUserDetail());
                    user.getUserDetail().setUser(user);

                    return userRepository.save(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> findAllBookings(Integer id) {

        List<Booking> bookings = bookingRepository.findBookingByUserId(id);
        return bookings.stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookingDTO findBookingByIdAndUser(Integer bookingId, Integer id){
        Booking booking = bookingRepository.findBookingByIdAndUserId(bookingId, id);
        return bookingMapper.toDto(booking);
    }

    @Override
    public User findById(Integer id) {
        Optional <User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void delete(Integer u) {
        userRepository.delete(userRepository.findById(u).get());
    }
}
