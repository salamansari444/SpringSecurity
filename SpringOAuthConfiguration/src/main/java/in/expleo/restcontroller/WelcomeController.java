package in.expleo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Welcome to Expleo Group";			
	}
}
