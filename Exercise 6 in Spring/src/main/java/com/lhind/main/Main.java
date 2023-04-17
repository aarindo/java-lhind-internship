package com.lhind.main;

import com.lhind.model.entity.Employee;
import com.lhind.repository.impl.EmployeeRepositoryImpl;
import com.lhind.service.impl.EmployeeServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setFirstName("Emri");
        emp.setLastName("MbIMERI");

        EmployeeRepositoryImpl emprp = new EmployeeRepositoryImpl();
        emprp.save(emp);

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.loadAllEmployees();
    }

}
