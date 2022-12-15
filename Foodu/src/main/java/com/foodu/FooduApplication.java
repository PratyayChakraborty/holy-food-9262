package com.foodu;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class FooduApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooduApplication.class, args);
	}
	
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
