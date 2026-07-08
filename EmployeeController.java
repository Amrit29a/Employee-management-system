package com.crctraining.employeemanagement.controller;

import com.crctraining.employeemanagement.entity.Employee;
import com.crctraining.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/employees")
   public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployeeById(id,employee),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/employees/search")
    public ResponseEntity<List<Employee>> searchByDepartment(@RequestParam String department){
        return new ResponseEntity<>(employeeService.getEmployeesByDepartment(department),HttpStatus.OK);
    }

    @GetMapping("/employees/page")
    public ResponseEntity<Page<Employee>> getEmployeesByPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "asc") String sortDirection){
        return new ResponseEntity<>(employeeService.getEmployeesByPage(page,size,sortBy,sortDirection),HttpStatus.OK);
    }
}
