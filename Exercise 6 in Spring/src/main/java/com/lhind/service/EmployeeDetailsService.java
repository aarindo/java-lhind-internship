package com.lhind.service;

import com.lhind.model.dto.EmployeeDetailsDTO;
import com.lhind.model.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsService {
    List<EmployeeDetailsDTO> loadAllEmployeeDetails();
    List<EmployeeDetailsDTO> deleteEmployeeDetails(EmployeeDetails userDetails);
    List<EmployeeDetailsDTO> findEmployeeDetailsById(Long id);
    List<EmployeeDetailsDTO> saveNewEmployeeDetails(EmployeeDetails userDetails);
}
