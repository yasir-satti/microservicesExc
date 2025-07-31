package com.example.microservice2.service;

import com.example.microservice2.entity.Student;
import com.example.microservice2.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public void save(Student student) {
    repository.save(student);
  }

}
