package com.example.microservices.service;

import com.example.microservices.Dto.StudentDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducerService {
  private final KafkaTemplate<String, StudentDTO> kafkaTemplate;

  public StudentProducerService(KafkaTemplate<String, StudentDTO> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendStudent(StudentDTO studentDTO){
    kafkaTemplate.send("students", studentDTO);
  }
}
