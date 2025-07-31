# Microservices

Create SQS queue, and send messages to the queue. Then the m,essages can be saved to the ElastiCache.

microservices tutorial using Spring Boot (Java 21) with Apache Kafka and MySQL, uses two services: 

1. Student Producer Service – Posts student records to Kafka. 
2. Student Consumer Service – Reads from Kafka and stores to MySQL.



## Architecture
* Configuration server
* Discovery service eureka
* Load balancing with AWS API gateway secured with OAuth2
* Student Producer Service
* Student Consumer Service

## Tech stack

* Java 21 
* Spring Boot 3.x 
* Apache Kafka 
* MySQL 8+ 
* Spring Data JPA 
* Spring Kafka 
* JUnit 5 + Mockito

## Running the projetc

* Start Docker: 

```docker-compose -f docker-compose.yml -p microservicesexc up -d```

* Start the configuration server
* Start the discovery service
* Start student-producer-service
* Start student-producer-service

Send POST request to:

```curl -X POST http://localhost:8081/students \
-H "Content-Type: application/json" \
-d '{"id":1,"name":"John Doe","email":"john@example.com"}'```