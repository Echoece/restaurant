package com.echo.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
@Slf4j
public class RestaurantApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }
}
