package com.lhind.mapper;

import com.lhind.model.dto.EmployeeDTO;
import com.lhind.model.entity.Employee;

public class EmployeeMapper extends AbstractMapper<Employee, EmployeeDTO> {

    private final EmployeeDetailsMapper employeeDetailsMapper;

    public EmployeeMapper() {
        this.employeeDetailsMapper = new EmployeeDetailsMapper();
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setMiddleName(employee.getMiddleName());
        employeeDTO.setEmploymentStatus(employee.getEmploymentStatus());
        employeeDTO.setEmployeeDetailsDTO(employeeDetailsMapper.toDto(employee.getEmployeeDetails()));
        return employeeDTO;
    }
}
