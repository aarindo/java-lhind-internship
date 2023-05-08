package com.lhind.internship.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightDTO {
    private String origin;
    private String destination;
    private String airline;
    private Integer flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
}
