package com.lhind.internship.springboot.model.dto;

import com.lhind.internship.springboot.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
    private String username;
    private RoleEnum role;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
}
