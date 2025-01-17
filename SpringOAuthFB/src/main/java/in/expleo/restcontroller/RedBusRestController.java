package in.expleo.restcontroller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusRestController {
	
	@GetMapping("/home")
	public String showHome() {
		return "Hello, Welcome to Home page of RedBus.com";
	}
	
	@GetMapping("/after")
	public String afterLoginPage() {
		return "Hello,Succesfully logged into RedBus.com";
	}
	
	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		System.out.println("Login Details "+principal.getName());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

}
