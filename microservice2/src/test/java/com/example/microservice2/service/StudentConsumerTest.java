package com.example.microservice2.service;

import com.example.microservice2.entity.Student;
import com.example.microservices.Dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentConsumerTest {

  @Mock
  StudentService service;

  @InjectMocks
  StudentConsumer consumer;

  @Test
  void shouldConsumeAndSave() {
    StudentDTO student = new StudentDTO(1L, "Jane", "d@f.v");
    consumer.consume(student);
    verify(service).save(any(Student.class));
  }
}
