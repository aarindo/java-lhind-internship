package com.lhind.internship.springboot.service;
import com.lhind.internship.springboot.model.dto.UserDetailDTO;
import com.lhind.internship.springboot.model.entity.UserDetail;

import java.util.List;

public interface UserDetailService {
    public UserDetailDTO save(UserDetail userDetail);

    public List<UserDetailDTO> findAll();

    public UserDetailDTO findById(Long id);

    public void delete(Long id);

    public UserDetailDTO convertToDTO(UserDetail userDetail);
}
