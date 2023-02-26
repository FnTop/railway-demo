package com.railway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/")
public class RailwayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayDemoApplication.class, args);
	}
	@PostMapping("/hello")
	public String hello() {
        return "deploy railway project for successful";
    }

}
