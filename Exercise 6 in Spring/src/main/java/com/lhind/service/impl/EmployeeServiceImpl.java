package com.lhind.service.impl;

import com.lhind.mapper.EmployeeMapper;
import com.lhind.model.dto.EmployeeDTO;
import com.lhind.model.entity.Employee;
import com.lhind.repository.impl.EmployeeRepositoryImpl;
import com.lhind.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl();
        this.employeeMapper = new EmployeeMapper();
    }

    @Override
    public List<EmployeeDTO> loadAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> delete(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeDTO> findEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> save(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeDTO> findEmployeeByUsername(String username) {
        return null;
    }

}
