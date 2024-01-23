package com.example.currencyexchangeserver;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    //bu fail olacaq
    @GetMapping("/sample-api")
   /* @Retry(name = "default") //default olaraq 3 defe request atir*/
    //@Retry(name = "default", fallbackMethod = "hardcodedResponse") //custom
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name = "default")
    @Bulkhead(name = "sample-api")
    public String sampleApi(){

        logger.info("Fail");
        var entity = new RestTemplate().getForEntity("http://localhost:8080/some", String.class);
        return entity.getBody();
    }

    public  String hardcodedResponse(Exception exception){
        return "fallback response";
    }
}
