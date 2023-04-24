package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;

import java.util.List;

public interface FlightService {
    public FlightDTO save(Flight flight);

    public List<FlightDTO> findAll();

    public FlightDTO findById(int id);

    public void delete(int id);

    public FlightDTO convertToDTO(Flight flight);
}
