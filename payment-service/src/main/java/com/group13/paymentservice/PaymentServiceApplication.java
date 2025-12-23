package com.group13.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for Payment Service microservice.
 *
 * <p>Runs a standalone Spring Boot application on the port defined in
 * application.properties (server.port=8084).</p>
 */
@SpringBootApplication
public class PaymentServiceApplication {

    /**
     * Application main method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}