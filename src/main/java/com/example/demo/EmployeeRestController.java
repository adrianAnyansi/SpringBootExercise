package com.example.demo;

import java.util.List;
import java.util.HashMap;
// import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
class EmployeeRestController {
    
    private final EmployeeRepository repository;

    EmployeeRestController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value="/about")
    public HashMap<String, Object> about() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("name", "Payroll REST API");
        jsonMap.put("version", "0.0.1"); // TODO: Reference from config
        return jsonMap;
    }

    // GET: Retrieve all employees
    @GetMapping(value="/employees")
    public List<Employee> getAll() {
        return repository.findAll();
    }

    // POST: Add new employee
    // NOTE: A new ID is created via JPA, investigate
    @PostMapping(value="/employee")
    public Employee addNewEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee); // returns added Employee
    }

    // // GET: Get Employee by object
    // @GetMapping(value="/employee")
    // public Employee getEmployee(@RequestParam Long employeeId) {
    //     return repository.findByObject(employeeId);
    // }
    
    // GET: Get Employee by ID
    @GetMapping(value="/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return repository.findById(employeeId).orElseThrow(
            () -> new EmployeeNotFoundException(employeeId)
        ); // NOTE: Built in try-catch?
        // return repository.findById(employeeId);
    }

    // PUT: Update Employee information
    @PutMapping(value="/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long employeeId) {
        
        try {
            Employee currEmployee = repository.findById(employeeId).get(); // retrieve optional value
            currEmployee.setName(newEmployee.getName());
            currEmployee.setRole(newEmployee.getRole());
            // TODO: Set comp and etc
            return currEmployee;
        } catch (EmployeeNotFoundException e) {
            // Employee ID does not exist, add as new employee
            newEmployee.setId(employeeId);
            return repository.save(newEmployee);
        }
        
    }

    // DELETE: Employee by ID
    @DeleteMapping(value="/employee/{id}")
    void deleteEmployee(@PathVariable Long employeeId) {
        repository.deleteById(employeeId);
    }
}
