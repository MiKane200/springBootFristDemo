package com.swpu.fourth_bootstrap_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class FourthBootstrapDemoApplication {

	@RequestMapping(value="/search",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Person search(String name){
		return new Person(name,32,"haihei");
	}

	public static void main(String[] args) {
		SpringApplication.run(FourthBootstrapDemoApplication.class, args);
	}
}
