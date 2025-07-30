package com.example.microservices.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoScaler {
//  @Value("${autoscaler.cpu.threshold}")
//  private double cpuThreshold;
//
//  @Value("${spring.application.name}")
//  private String serviceName;
//
//  @Scheduled(fixedRate = 60000) // Check every minute
//  public void autoScale() {
//    double cpuUsage = getCpuUsage(serviceName);
//
//    if (cpuUsage > cpuThreshold) {
//      // Scale up
//      System.out.println("Scaling up " + serviceName + " due to high CPU usage.");
//      // Trigger instance creation
//      scaleUp();
//    } else {
//      // Scale down
//      System.out.println("Scaling down " + serviceName + " due to low CPU usage.");
//      // Trigger instance termination
//      scaleDown();
//    }
//  }
//
//  private double getCpuUsage(String serviceName) {
//    // Placeholder for actual CPU usage metric collection
//    return 0.5; // Replace with real data
//  }
//
//  private void scaleUp() {
//    // Placeholder for scale-up logic
//    System.out.println("Scaling up the number of instances.");
//  }
//
//  private void scaleDown() {
//    // Placeholder for scale-down logic
//    System.out.println("Scaling down the number of instances.");
//  }
}
