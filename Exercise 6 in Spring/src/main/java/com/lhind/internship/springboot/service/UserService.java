package com.lhind.internship.springboot.service;

import com.lhind.internship.springboot.model.dto.UserDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {

    List<UserDTO> loadAll();

    UserDTO loadById(Long id) throws ChangeSetPersister.NotFoundException;

    UserDTO storeUser(UserDTO userDTO);
}
