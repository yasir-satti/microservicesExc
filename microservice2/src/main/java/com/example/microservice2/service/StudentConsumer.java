package com.example.microservice2.service;

import com.example.microservice2.entity.Student;
import com.example.microservices.Dto.StudentDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StudentConsumer {
  private final StudentService studentService;

  public StudentConsumer(StudentService studentService) {
    this.studentService = studentService;
  }

  @KafkaListener(topics = "students", groupId = "student_group")
  public void consume(StudentDTO dto) {
    Student student = new Student();
    student.setId(dto.id());
    student.setName(dto.name());
    student.setEmail(dto.email());
    studentService.save(student);
  }
}
