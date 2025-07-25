package com.example.springcloudgateway.controller;

import com.example.springcloudgateway.component.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @GetMapping("/token")
  public String getToken(@RequestParam String username, @RequestParam String role) {
    return jwtTokenProvider.createToken(username, role);
  }
}
