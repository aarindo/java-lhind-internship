package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.model.dto.FlightDTO;
import com.lhind.internship.springboot.model.entity.Flight;
import com.lhind.internship.springboot.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<FlightDTO> findAll(){
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public FlightDTO findById(@PathVariable(name = "id") int id){
        FlightDTO flightDTO = flightService.findById(id);
        if (flightDTO != null){
            return flightDTO;
        }
        else {
            throw new ResponseStatusException(HttpStatus.resolve(404), "Flight not found");
        }
    }

    @PostMapping
    public FlightDTO save(@RequestBody Flight flight){
        return flightService.save(flight);
    }

    @PutMapping
    public FlightDTO put(@RequestBody Flight flight){
        return flightService.save(flight);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable(name = "id") int id){
        try {
            flightService.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

