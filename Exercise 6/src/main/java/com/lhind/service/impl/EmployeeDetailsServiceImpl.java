package com.lhind.service.impl;

import com.lhind.repository.impl.EmoployeeDetailsRepositoryImpl;
import com.lhind.mapper.EmployeeDetailsMapper;
import com.lhind.model.dto.EmployeeDetailsDTO;
import com.lhind.model.entity.EmployeeDetails;
import com.lhind.service.EmployeeDetailsService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    private final EmoployeeDetailsRepositoryImpl EmoployeeDetailsRepository;
    private final EmployeeDetailsMapper EmployeeDetailsMapper;

    public EmployeeDetailsServiceImpl(EmoployeeDetailsRepositoryImpl emoployeeDetailsRepository) {
        EmoployeeDetailsRepository = emoployeeDetailsRepository;
        this.EmployeeDetailsMapper = new EmployeeDetailsMapper();
    }
    
    @Override
    public List<EmployeeDetailsDTO> loadAllEmployeeDetails() {
        return EmoployeeDetailsRepository.findAll().stream().map(EmployeeDetailsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDetailsDTO> deleteEmployeeDetails(EmployeeDetails userDetails) {
        return null;
    }

    @Override
    public List<EmployeeDetailsDTO> findEmployeeDetailsById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDetailsDTO> saveNewEmployeeDetails(EmployeeDetails userDetails) {
        return null;
    }

}
