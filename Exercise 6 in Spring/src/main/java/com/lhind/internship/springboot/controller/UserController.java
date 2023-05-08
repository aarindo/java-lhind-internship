package com.lhind.internship.springboot.controller;

import com.lhind.internship.springboot.mapper.UserMapper;
import com.lhind.internship.springboot.model.dto.UserDTO;
import com.lhind.internship.springboot.model.entity.User;
import com.lhind.internship.springboot.service.BookingService;
import com.lhind.internship.springboot.service.UserDetailService;
import com.lhind.internship.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    UserService userService;
    UserDetailService userDetailService;
    BookingService bookingService;
    UserMapper userMapper;

    @PreAuthorize(value = "hasRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> get(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PreAuthorize(value = "hasRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        User user1 = userService.findById(id);
        if (user1 != null) {
            UserDTO userDTO = userMapper.toDto(user1);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize(value = "hasRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.POST, value = {"/add"})
    public ResponseEntity<UserDTO> saveUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PreAuthorize(value = "hasRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User savedUser = userService.update(id, updatedUser);
        return ResponseEntity.ok(userMapper.toDto(savedUser));
    }

    @PreAuthorize(value = "hasRole('ROLE_MANAGER')")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
