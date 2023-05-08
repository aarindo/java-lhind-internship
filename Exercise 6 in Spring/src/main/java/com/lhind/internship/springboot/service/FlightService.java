package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    FlightDTO save(Flight f);

    List<FlightDTO> findAll();

    Optional<Flight> findById(Integer id);

    void delete(Flight f);

}
