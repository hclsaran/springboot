package com.hcl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaranController {

	@GetMapping("/api/saran")
	public String getSwagger() {
		return "Welcome to Swagger";
	}
	
	@GetMapping("/api/login")
	public String getLogin() {
		return "Welcome to Login";
	}
	
	@GetMapping("/api/register")
	public String getRegister() {
		return "Welcome to Register";
	}

}
