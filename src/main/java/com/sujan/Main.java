package com.sujan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }
}

/*
 @SpringBootApplication for class to indicate that this is spring boot application

 SpringApplication.run(Main.class, args) to run the spring boot application inside main method

 @RestController for class to build rest controllers
 @GetMapping for method which is inside @RestController class for making rest endpoints

 When you run your application first time, target folder will be generated

 To configure webserver, ssl, http/2 -> we have application.yml or application.properties
 Located inside src/resources
*/
