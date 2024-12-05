package com.employee_management.employee_management.repository;

import com.employee_management.employee_management.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByFirstNameContainingOrLastNameContainingOrPhoneContainingOrEmailContainingOrDepartmentContaining(
            String firstName, String lastName, String phone, String email, String department);
}
