package com.lhind.internship.springboot.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class AuthenticationResponse {
    private String token;
}
