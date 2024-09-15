package in.expleo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.expleo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	
	@GetMapping("/register")
	public String showrRegisterPage(@ModelAttribute("userInfo") in.expleo.model.UserDetails details) {
		System.out.println("UserController.showrRegisterPage()");
		return "user_register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo") in.expleo.model.UserDetails details, Map<String, Object> map) {
		System.out.println("UserController.registerUser()");
		
		String resultMsg = service.register(details);
		map.put("message", resultMsg);
		return "user_registered_success";
		
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "custom_login";
	}

}
