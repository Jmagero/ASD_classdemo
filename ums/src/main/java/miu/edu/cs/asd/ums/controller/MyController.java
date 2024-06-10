package miu.edu.cs.asd.ums.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello/fullName")
    public String sayHello(@RequestParam String firstName,
                           @RequestParam String lastName) {
        return "Hello, " + firstName + " " + lastName;
    }

    @GetMapping("another_hello")
    public ResponseEntity<String> sayAnotherHello(){
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("another_hello/{name}")
    public String sayAnotherHello(@PathVariable("name") String myName){
        return "Hello World! " + myName;
    }


}
