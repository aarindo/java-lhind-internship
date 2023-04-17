package com.lhind.service;

import com.lhind.model.dto.EmployeeDTO;
import com.lhind.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> loadAllEmployees();
    List<EmployeeDTO> delete(Employee employee);
    List<EmployeeDTO> findEmployeeById(Long id);
    List<EmployeeDTO> save(Employee employee);
    List<EmployeeDTO> findEmployeeByUsername(String username);
}
