package com.dheeraj.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
//@Retry(name = "default", fallbackMethod = "hardCodedFallbackMethod")
//@CircuitBreaker(name = "default", fallbackMethod = "hardCodedFallbackMethod")
//@RateLimiter(name = "sample-api")
@Bulkhead(name = "sample-api")
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sample-api")
	public String sampleApi() {
		// let's call a service which even doesn't exist
		logger.info("<------------ Sample Api is called. ----------->");
//		ResponseEntity<String> dummyUrlResponseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url",String.class);
//		
//		return dummyUrlResponseEntity.getBody();
		return "Sample API";
	}
	public String hardCodedFallbackMethod(Exception ex) {
		return "Hard Coded Fallback Method";
	}
}
