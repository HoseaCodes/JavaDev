package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	public class Greeting {

		private final long id;
		private final String content;
	
		public Greeting(long id, String content) {
			this.id = id;
			this.content = content;
		}
	
		public long getId() {
			return id;
		}
	
		public String getContent() {
			return content;
		}
	}

}
