package com.ljh.phonehystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class PhonehystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonehystrixApplication.class, args);
    }

}
