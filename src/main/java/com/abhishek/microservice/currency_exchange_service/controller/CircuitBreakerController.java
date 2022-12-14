package com.abhishek.microservice.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping(value = "/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "DummyMethod")
    //@CircuitBreaker(name = "sample-api",fallbackMethod = "DummyMethod")
    //@RateLimiter(name="sample-api")
    @Bulkhead(name = "sample-api")
    public String sampleApi(){
        //logger.info("Sample API call received");
        //String responseEntity = new RestTemplate().getForEntity("http://dummyurl.xyz",String.class).getBody();
        return "Sample API";
    }

    public String DummyMethod(Throwable throwable){
        return "Fallback Response";
    }
}
