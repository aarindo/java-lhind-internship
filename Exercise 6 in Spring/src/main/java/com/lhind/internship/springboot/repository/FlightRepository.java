package com.lhind.internship.springboot.repository;

import com.lhind.internship.springboot.mapper.FlightMapper;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository <Flight, Integer> {
    List<Flight> findFlightByBookings(Booking booking);
    Flight findFlightByDepartureDateAndOrigin(Date date, String airport);
}
