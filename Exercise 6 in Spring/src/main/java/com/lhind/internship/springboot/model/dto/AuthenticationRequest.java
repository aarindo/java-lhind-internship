package com.lhind.internship.springboot.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
