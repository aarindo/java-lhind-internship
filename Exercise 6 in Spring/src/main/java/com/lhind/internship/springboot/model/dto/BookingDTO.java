package com.lhind.internship.springboot.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lhind.internship.springboot.model.entity.Booking;
import com.lhind.internship.springboot.model.enums.BookingStatus;

import java.sql.Date;

@JsonSerialize
public class BookingDTO {
    private Integer id;
    private BookingStatus bookingStatus;
    private Date bookingDate;

    public BookingDTO() {}

    public BookingDTO(Booking booking) {
        this.setId(booking.getId());
        this.setBookingDate((Date) booking.getBookingStartDate());
        this.setBookingStatus(booking.getBookingStatus());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
