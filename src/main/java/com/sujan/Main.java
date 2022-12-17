package com.sujan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response =  new GreetResponse(
                "Hello",
                List.of("Java","Javascript","Python"),
                new Person("Sujan")
        );
        return response;
    }

    /*
    public String greet() {
        return "Hello";
    }
    */

    record Person(String name){}

     record GreetResponse(
             String greet,
             List<String> favProgrammingLanguage,
             Person person
     ) {}

    /*
    class GreetResponse{
        public final String greet;

        GreetResponse(String greet){
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }
    */
}

/*
 @....... are annotation

 What are syntactic sugar?

 @SpringBootApplication for class to indicate that this is spring boot application

 SpringApplication.run(Main.class, args) to run the spring boot application inside main method

 @RestController for class to build rest controllers and method will return a JSON response
 @RestController is a combination of @Controller and @ResponseBody

 @Controller -> mark class as a web controller
 @ResponseBody -> all the methods will return a JSON response

 @GetMapping for method which is inside @RestController class for making rest endpoints

 When you run your application first time, target folder will be generated

 To configure webserver, ssl, http/2 -> we have application.yml or application.properties
 Located inside src/resources

 @RequestBody -> bind the HTTP request body to a Java object and
 also is used in conjunction with the spring mvc web framework

 @RequestMapping(method= RequestMethod.GET, value="/path") annotation specifies a method in the controller
 that should be responsible for serving the HTTP request to the given path, or endpoint.

 @GetMapping(value= "/path") -> the read in crud but as a http resource

 @PostMapping(value= "/path") -> the create in crud but as a http resource

 @PutMapping(value= "/path") -> the update in crud but as a http resource

 @DeleteMapping(value= "/path") -> the delete in crud but as a http resource

 @RequestParam(value= "name", defaultValue="World") -> the methods handling the requests might
 take parameters. To help you with binding the HTTP parameters into the action method arguments.
 Spring will parse the request parameters and put the appropriate ones into your method arguments

 @PathVariable("placeholderName")

 In java, record is a special type of class declaration aimed at reducing the boilerplate code.

 Response is in JSON due to library called Jackson -> the java json library or
 the best JSON parser for java or json for java
 Jackson basically transform Java objects to JSON in a nutshell
*/
