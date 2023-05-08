package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.entity.UserDetail;
import com.lhind.internship.springboot.repository.UserDetailRepository;
import com.lhind.internship.springboot.service.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {

    UserDetailRepository user;
    public UserDetail save(UserDetail u){
        return user.save(u);
    }

    public Optional<UserDetail> findById(Integer id) {
        return user.findById(id);
    }
}
