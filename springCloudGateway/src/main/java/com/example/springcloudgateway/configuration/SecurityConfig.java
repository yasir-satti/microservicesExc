package com.example.springcloudgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

//  @Bean
//  public MapReactiveUserDetailsService userDetailsService() {
//    UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("user")
//            .roles("USER")
//            .build();
//    return new MapReactiveUserDetailsService(user);
//  }

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.csrf().disable()
            .authorizeExchange(
                    exchanges -> exchanges.pathMatchers("/**")
                            .permitAll()
                            .anyExchange()
                            .authenticated())
            .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
    return http.build();
  }

  @Bean
  public ReactiveJwtDecoder jwtDecoder() {
    String jwkSetUri = "http://localhost:8080/oauth2/default"; // Verify this URI
    return NimbusReactiveJwtDecoder.withJwkSetUri(jwkSetUri).build();
  }

}
