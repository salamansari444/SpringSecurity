package com.expleo.restcontroller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to HDFC BANK";
	}
	
	@GetMapping("/greet")
	public String greet() {
		 LocalTime time = LocalTime.now();
		int hour = time.getHour();
		String msg = "";
		if(hour>10 && hour< 19) {
			msg="Work WOrk";
		}else {
			msg="Enjoy";
		}
		return msg;
	}
	
	@GetMapping("/transfer")
	public String fundTransfer() {
		return "Fund Transfer Initiated...";
	}
	
	@GetMapping("/balance")
	public String checkBalance(){
		return "Balance Amount is 100000000 INR";
	}
	
	@GetMapping("/about")
	public String about() {
		return "About us";
	}
}
