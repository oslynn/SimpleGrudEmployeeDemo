package com.employee.controller;

import com.employee.controller.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }


    @GetMapping("/employee/{employeeId}")
    public Employee getAllEmployeesByEmployeeId(@PathVariable(value = "employeeId") Integer employeeId,
                                                Pageable pageable) {
        return employeeRepository.findById(employeeId).map(employee -> {
            return employee;
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));

    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable Integer employeeId, @Valid @RequestBody Employee employeeRequest) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employeeRequest.setId(employee.getId());
            return employeeRepository.save(employeeRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }


    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employeeRepository.delete(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }

}
