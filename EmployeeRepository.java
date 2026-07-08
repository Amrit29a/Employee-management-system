package com.crctraining.employeemanagement.repository;

import com.crctraining.employeemanagement.entity.Department;
import com.crctraining.employeemanagement.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByDepartmentName(String department);
}
