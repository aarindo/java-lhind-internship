package com.lhind.internship.springboot.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lhind.internship.springboot.model.entity.Flight;

import java.sql.Date;

@JsonSerialize
public class FlightDTO {
    private String airline;
    private String destination;
    private String origin;
    private String status;
    private Date arrivalDate;
    private Date departureDate;

    public FlightDTO() {}

    public FlightDTO(Flight flight) {
        this.airline = flight.getAirline();
        this.destination = flight.getDestination();
        this.origin = flight.getOrigin();;
        this.status = flight.getStatus();
        this.arrivalDate = flight.getArrivalDate();
        this.departureDate = flight.getDepartureDate();
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
