package com.example.microservices.controller;

import com.example.microservices.Dto.StudentDTO;
import com.example.microservices.service.StudentProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentProducerService producerService;

  public StudentController(StudentProducerService producerService) {
    this.producerService = producerService;
  }

  @PostMapping
  private ResponseEntity<Void> postStudent(@RequestBody StudentDTO studentDTO) {
    producerService.sendStudent(studentDTO);
    return ResponseEntity.accepted().build();
  }

}
