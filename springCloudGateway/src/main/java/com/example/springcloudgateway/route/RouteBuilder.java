package com.example.springcloudgateway.route;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class RouteBuilder {

  @Bean
  public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){
    return routeLocatorBuilder.routes()
            .route("Microservice1",r->r.path("/students/**")
                    .uri("http://localhost:9099/"))
            .route("Microservice2",r->r.path("/students/**")
                    .uri("http://localhost:9098/"))
            .build();
  }

  @Bean
  @Primary
  WebFluxProperties webFluxProperties(){
    return new WebFluxProperties();
  }
}

