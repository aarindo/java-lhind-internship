package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Integer> {

}
