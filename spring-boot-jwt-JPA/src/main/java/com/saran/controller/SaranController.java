package com.saran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaranController {
//Business Logic
	@RequestMapping({ "/businesslogic" })
	public String welcome() {
		return "Welcome to the world of Controller";
	}

}