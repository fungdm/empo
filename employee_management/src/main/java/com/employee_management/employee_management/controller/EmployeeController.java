package com.employee_management.employee_management.controller;

import com.employee_management.employee_management.model.Employee;
import com.employee_management.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Search employees
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String firstName, @RequestParam String lastName,
                                           @RequestParam String phone, @RequestParam String email, @RequestParam String department) {
        return employeeService.searchEmployees(firstName, lastName, phone, email, department);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    // Add or update employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
