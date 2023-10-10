package com.bitlabs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller { 

	@GetMapping("/delete") 
	public String delete() 
	{ 
		return "This is the delete request"; 
	} 
}
