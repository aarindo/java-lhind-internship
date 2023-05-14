package com.lhind.internship.springboot.model.dto;

import lombok.Data;

@Data
public class AuthenticationResponse extends BaseResponse {
    private String token;
}
