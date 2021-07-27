package com.example.java;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Shorthand for @Controller and RepsonseBody
// Marks as a controller where every method returns a
// domain object instead of a view
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// Ensures that HTTP GET requests to /greeting
	// are mapped to the greeting() method
	@GetMapping("/greeting")
	// RequestParam binds the value of the query string parameter name into the name
	// paramater of the greeting method
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}