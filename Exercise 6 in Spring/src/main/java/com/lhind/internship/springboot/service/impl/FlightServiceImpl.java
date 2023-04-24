package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;
import com.lhind.internship.springboot.repository.FlightRepository;
import com.lhind.internship.springboot.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDTO save(Flight flight) {
        return convertToDTO(flightRepository.save(flight));
    }

    @Override
    public List<FlightDTO> findAll() {
        List<FlightDTO> flightDTOList = flightRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        return flightDTOList;
    }

    @Override
    public FlightDTO findById(int id) {
        Flight flight = new Flight();
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()){
            flight = flightOptional.get();
        }
        return convertToDTO(flight);
    }

    @Override
    public void delete(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public FlightDTO convertToDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setAirline(flight.getAirline());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setStatus(flight.getStatus());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDepartureDate(flight.getDepartureDate());

        return flightDTO;
    }
}
