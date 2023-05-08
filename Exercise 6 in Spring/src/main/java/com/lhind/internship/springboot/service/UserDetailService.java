package com.lhind.internship.springboot.service;
import com.lhind.internship.springboot.model.entity.UserDetail;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    UserDetail save(UserDetail u);
    Optional <UserDetail> findById(Integer id);
}
