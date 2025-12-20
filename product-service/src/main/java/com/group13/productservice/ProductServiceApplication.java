package com.group13.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for Product Service microservice.
 *
 * <p>Runs a standalone Spring Boot application on the port defined in
 * application.properties (server.port=8082).</p>
 */
@SpringBootApplication
public class ProductServiceApplication {

    /**
     * Application main method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
