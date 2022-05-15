package com.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String getData()
	{
		return "<body bgcolor='red' text='yellow'><h1>Testing.....</h1></body>";
	}

}
