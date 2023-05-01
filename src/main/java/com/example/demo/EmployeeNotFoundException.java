package com.example.demo;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long employeeId) {
        super("Could not find employee id:"+employeeId);
    }
}