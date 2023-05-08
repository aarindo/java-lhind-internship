package com.lhind.internship.springboot.model.dto;
import com.lhind.internship.springboot.model.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingDTO {
    private String username;
    private BookingStatus bookingStatus;
    private Date bookingDate;
    private List<FlightDTO> flights;
    private List<Integer> flightIds;
}
