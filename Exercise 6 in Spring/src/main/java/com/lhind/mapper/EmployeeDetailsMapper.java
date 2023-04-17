package com.lhind.mapper;

import com.lhind.model.dto.EmployeeDetailsDTO;
import com.lhind.model.entity.EmployeeDetails;

public class EmployeeDetailsMapper extends AbstractMapper<EmployeeDetails, EmployeeDetailsDTO> {

    @Override
    public EmployeeDetails toEntity(EmployeeDetailsDTO dto) {
        return null;
    }

    @Override
    public EmployeeDetailsDTO toDto(EmployeeDetails entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();
        employeeDetailsDTO.setId(entity.getId());
        employeeDetailsDTO.setEmail(entity.getEmail());
        employeeDetailsDTO.setPhoneNumber(entity.getPhoneNumber());
        employeeDetailsDTO.setEmploymentDate(entity.getEmploymentDate());
        return employeeDetailsDTO;
    }
}
