package com.lhind.internship.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lhind.internship.springboot.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "booking_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bookingDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "book_flight",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<Flight> flights;
}
