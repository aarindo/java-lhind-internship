package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.mapper.FlightMapper;
import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;
import com.lhind.internship.springboot.service.FlightService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
@Schema
public class FlightController {
    FlightService flightService;
    FlightMapper flightMapper;

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FlightDTO>> findAll() {
        return ResponseEntity.ok(flightService.findAll());
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<FlightDTO> findById(@PathVariable("id") Integer id) {
        Optional<Flight> flightOptional = flightService.findById(id);
        return flightOptional.map(flight -> ResponseEntity.ok(flightMapper.toDto(flight))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.save(flight));
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        flightService.delete(flightService.findById(id).get());
    }
}

