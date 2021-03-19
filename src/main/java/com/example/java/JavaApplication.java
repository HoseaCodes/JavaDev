package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// REST API
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class JavaApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Bean
	//uses the Jackson JSON processing library to process the incoming data.
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	// runs the RestTemplate and, consequently, fetches our quotation on startup.
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}