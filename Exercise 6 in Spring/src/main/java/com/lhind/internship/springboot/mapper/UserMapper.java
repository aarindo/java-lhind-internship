package com.lhind.internship.springboot.mapper;

import com.lhind.internship.springboot.model.dto.UserDTO;
import com.lhind.internship.springboot.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO> {

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO(user.getUsername(),
                user.getRole(),
                user.getUserDetail().getFirstname(),
                user.getUserDetail().getLastname(),
                user.getUserDetail().getPhoneNumber(),
                user.getUserDetail().getEmail());
        return userDTO;
    }
}