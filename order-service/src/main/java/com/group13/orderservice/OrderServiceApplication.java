package com.group13.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for Order Service microservice.
 *
 * <p>Runs a standalone Spring Boot application on the port defined in
 * application.properties (server.port=8083).</p>
 */
@SpringBootApplication
public class OrderServiceApplication {

    /**
     * Application main method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}