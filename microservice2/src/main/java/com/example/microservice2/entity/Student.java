package com.example.microservice2.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
public class Student {
  @Id
  private Long id;
  private String name;
  private String email;
}
