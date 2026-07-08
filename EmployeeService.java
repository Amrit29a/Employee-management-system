package com.crctraining.employeemanagement.service;

import com.crctraining.employeemanagement.entity.Department;
import com.crctraining.employeemanagement.entity.Employee;
import com.crctraining.employeemanagement.exception.DepartmentNotFoundException;
import com.crctraining.employeemanagement.exception.EmployeeNotFoundException;
import com.crctraining.employeemanagement.repository.DepartmentRepository;
import com.crctraining.employeemanagement.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with id: "+id));
    }

    public Employee createEmployee(Employee employee){
        Long departmentId=employee.getDepartment().getId();
        Department department=departmentRepository.findById(departmentId).orElseThrow(()->
                new DepartmentNotFoundException("Department not found with id: "+departmentId));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public String updateEmployeeById(Long id,Employee employee){
        Long departmentId=employee.getDepartment().getId();
        Department department=departmentRepository.findById(departmentId).orElseThrow(()->
                new DepartmentNotFoundException("Department not found with id: "+departmentId)
                );
        employee.setDepartment(department);
        employee.setId(id);
        return "Employee with id:"+getEmployeeById(id)+" has been updated successfully";
    }

    public String deleteEmployeeById(Long id){
        String message=getEmployeeById(id)+" has been deleted successfully";
        employeeRepository.deleteById(id);
        return message;
    }

    public List<Employee> getEmployeesByDepartment(String department){
        return employeeRepository.findByDepartmentName(department);
    }

    public Page<Employee> getEmployeesByPage(int page,int size,String sortBy,String sortDirection){
        Sort sort;
        if(sortDirection.equalsIgnoreCase("desc")) sort=Sort.by(sortBy).descending();
        else sort=Sort.by(sortBy).ascending();
        Pageable pageable= PageRequest.of(page,size, sort);
        return employeeRepository.findAll(pageable);
    }
}
