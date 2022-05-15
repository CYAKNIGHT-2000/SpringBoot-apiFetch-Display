package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiFetchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFetchApplication.class, args);
	}
	
	@Bean
	public  RestTemplate createRestTemplate(RestTemplateBuilder restTemplateBuilder)
	{
		return restTemplateBuilder.build();
	}

}
