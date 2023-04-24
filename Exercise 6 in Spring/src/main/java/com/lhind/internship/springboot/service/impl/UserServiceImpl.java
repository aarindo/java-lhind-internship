package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.dto.UserDTO;
import com.lhind.internship.springboot.model.enums.EmploymentStatus;
import com.lhind.internship.springboot.service.UserService;
import com.lhind.internship.springboot.model.entity.User;
import com.lhind.internship.springboot.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> loadAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO loadById(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id).map(UserDTO::new).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public UserDTO storeUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setEmploymentStatus(EmploymentStatus.ACTIVE);
        return new UserDTO(userRepository.save(user));
    }

}
