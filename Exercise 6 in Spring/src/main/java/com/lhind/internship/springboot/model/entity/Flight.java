package com.lhind.internship.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "airline")
    private String airline;

    @Column(name = "flight_number")
    private Integer flightNumber;

    @Column(name = "departure_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureDate;

    @Column(name = "arrival_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date arrivalDate;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "flights")
    private List<Booking> bookings;
}