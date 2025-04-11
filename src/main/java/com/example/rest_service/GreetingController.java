package com.example.rest_service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // HTTP requests are handled here, from the @RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting") // Ensures GET request to /greeting are mapped to the greeting() method
      public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		    return new Greeting(counter.incrementAndGet(), String.format(template, name));
	  }
} 