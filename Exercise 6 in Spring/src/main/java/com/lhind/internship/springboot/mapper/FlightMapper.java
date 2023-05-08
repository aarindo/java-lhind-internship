package com.lhind.internship.springboot.mapper;

import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper extends AbstractMapper <Flight, FlightDTO>{

    @Override
    public FlightDTO toDto(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setStatus(flight.getStatus());
        return flightDTO;
    }
}
