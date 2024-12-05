package com.employee_management.employee_management.service;

import com.employee_management.employee_management.model.Employee;
import com.employee_management.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    // Search employees
    public List<Employee> searchEmployees(String firstName, String lastName, String phone, String email, String department) {
        return employeeRepository.findByFirstNameContainingOrLastNameContainingOrPhoneContainingOrEmailContainingOrDepartmentContaining(
            firstName, lastName, phone, email, department);
    }

    // Delete employee by ID
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
