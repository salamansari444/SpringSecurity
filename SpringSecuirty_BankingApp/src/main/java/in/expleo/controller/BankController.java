package in.expleo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
	
	@GetMapping("/")
	public String callHome() {
		return "home";
	}
	
	@GetMapping("/loan")
	public String getLoan() {
		return "loan";
	}
	
	@GetMapping("/balance")
	public String checkBalance() {
		return "balance";
	}
	
	@GetMapping("/payment")
	public String makePay(){
		return "payment";
	}
}
