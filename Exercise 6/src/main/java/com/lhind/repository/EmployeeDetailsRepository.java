package com.lhind.repository;

import com.lhind.model.entity.Employee;
import com.lhind.model.entity.EmployeeDetails;

import java.util.Optional;

public interface EmployeeDetailsRepository extends Repository <EmployeeDetails, Long>{
    Optional<EmployeeDetails> findByEmail(String email);
}
