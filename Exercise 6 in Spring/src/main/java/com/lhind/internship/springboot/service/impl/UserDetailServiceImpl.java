package com.lhind.internship.springboot.service.impl;

import com.lhind.internship.springboot.model.dto.UserDetailDTO;
import com.lhind.internship.springboot.model.entity.UserDetail;
import com.lhind.internship.springboot.repository.UserDetailRepository;
import com.lhind.internship.springboot.service.UserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailsRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailDTO save(UserDetail userDetail) {
        return convertToDTO(userDetailsRepository.save(userDetail));
    }

    @Override
    public List<UserDetailDTO> findAll() {
        List<UserDetailDTO> userDetailDTOList = userDetailsRepository.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
        return userDetailDTOList;
    }

    @Override
    public UserDetailDTO findById(Long id) {
        UserDetail userDetail = new UserDetail();
        Optional<UserDetail> userDetailsOptional = userDetailsRepository.findById(id);
        if (userDetailsOptional.isPresent()){
            userDetail = userDetailsOptional.get();
        }
        return convertToDTO(userDetail);
    }


    @Override
    public void delete(Long id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public UserDetailDTO convertToDTO(UserDetail userDetail) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();

        userDetailDTO.setEmail(userDetail.getEmail());
        userDetailDTO.setPhoneNumber(userDetail.getPhoneNumber());

        return userDetailDTO;
    }
}
