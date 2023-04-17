package com.lhind.service;

import com.lhind.model.dto.FlightDTO;
import com.lhind.model.entity.Flight;

import java.util.List;

public interface FlightService {
    List<FlightDTO> loadAllFlights();
    List<FlightDTO> deleteFlight(Flight flight);
    List<FlightDTO> findFlightById(Long id);
    List<FlightDTO> saveNewFlight(Flight flight);
    List<FlightDTO> findByOrigin(String origin);
}
