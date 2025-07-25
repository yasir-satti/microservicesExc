package com.example.microservice2.controller;

import com.example.microservice2.response.EmployeeResponse;
import com.example.microservice2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employees/{id}")
  private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
    EmployeeResponse employee = employeeService.getEmployeeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(employee);
  }

}
