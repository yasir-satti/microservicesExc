package com.example.microservices.service;

import com.example.microservices.Dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentProducerServiceTest {

  @Mock
  KafkaTemplate<String, StudentDTO> kafkaTemplate;

  @InjectMocks
  StudentProducerService service;

  @Test
  void shouldSendStudent() {
    StudentDTO student = new StudentDTO(1L, "Jake", "a@d.c");
    service.sendStudent(student);
    verify(kafkaTemplate).send("students", student);
  }
}
