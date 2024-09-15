package com.expleo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {
	
	
	@GetMapping("/")
	public String welcome() {
		return "Welocme to the Expleo Company....";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "This is USER...";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "This is ADMIN....";
	}

}
