package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    /*Construtor Injection Method*/
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public List<Employee> searchAll() {
        return employeeRepository.findAll();
    }

    public Employee searchById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            //Throw a error
        }
        return employee;
    }

    public Employee update(Long employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee == null) {
            // throw error
        }

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        
        Employee updatedEmployee = employeeRepository.save(employee);

        return updatedEmployee;
    }
}
