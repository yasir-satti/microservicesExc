package com.example.microservices.service;

import com.example.microservices.entity.Employee;
import com.example.microservices.repository.EmployeeRepo;
import com.example.microservices.response.EmployeeResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepo employeeRepo;

  @Autowired
  private ModelMapper mapper;

  @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
  public EmployeeResponse getEmployeeById(int id) {
    Optional<Employee> employee = employeeRepo.findById(id);
    EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
    return employeeResponse;
  }

}
