package com.example.microservice2.configuration;

import com.example.microservice2.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

  @Bean
  public EmployeeService employeeBean() {
    return new EmployeeService();
  }

  @Bean
  public ModelMapper modelMapperBean() {
    return new ModelMapper();
  }

}
