package in.expleo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestcontroller {
	
	@Autowired
	private AuthenticationManager authenManager;
	
	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}
	
}
