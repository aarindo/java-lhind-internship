package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.mapper.FlightMapper;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;
import com.lhind.internship.springboot.repository.FlightRepository;
import com.lhind.internship.springboot.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private FlightMapper flightMapper;
    @Override
    public FlightDTO save(Flight f) {
        flightRepository.save(f);
        return flightMapper.toDto(f);
    }

    @Override
    public List<FlightDTO> findAll() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDTO> flightDTOs = new ArrayList<>();
        for (Flight flight : flights) {
            flightDTOs.add(flightMapper.toDto(flight));
        }
        return flightDTOs;
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return flightRepository.findById(id);
    }

    @Override
    public void delete(Flight f) {
        flightRepository.delete(f);
    }
}
