package com.lhind.service.impl;

import com.lhind.mapper.FlightMapper;
import com.lhind.model.dto.FlightDTO;
import com.lhind.model.entity.Flight;
import com.lhind.repository.impl.FlightRepositoryImpl;
import com.lhind.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightRepositoryImpl flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl() {
        this.flightMapper = new FlightMapper();
        this.flightRepository = new FlightRepositoryImpl();
    }

    @Override
    public List<FlightDTO> loadAllFlights() {
        return flightRepository.findAll().stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> deleteFlight(Flight flight) {
        return null;
    }

    @Override
    public List<FlightDTO> findFlightById(Long id) {
        return null;
    }

    @Override
    public List<FlightDTO> saveNewFlight(Flight flight) {
        return null;
    }

    @Override
    public List<FlightDTO> findByOrigin(String origin) {
        return flightRepository.findByOrigin(origin).stream().map(flightMapper::toDto).collect(Collectors.toList());
    }
}