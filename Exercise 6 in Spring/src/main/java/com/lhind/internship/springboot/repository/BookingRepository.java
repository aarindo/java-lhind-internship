package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Integer> {
    List<Booking> findBookingByUserId(Integer id);
    Booking findBookingByIdAndUserId(Integer bookingId, Integer userId);
}
