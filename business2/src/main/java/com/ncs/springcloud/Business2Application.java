package com.ncs.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class Business2Application {

    public static void main(String[] args) {
        SpringApplication.run(Business2Application.class, args);
    }

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod="business2Fallback")
    public String home() {

        int i = 1/0;

        return "business2";
    }

    public String business2Fallback() {
        return "business2Fallback";
    }

}