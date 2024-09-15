package in.expleo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.expleo.entity.User;
import in.expleo.service.UserService;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		System.out.println("UserController.initRoleAndUser()");
		userService.initRoleAndUser();
	}

	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user) {
		System.out.println("UserController.registerNewUser()");
		return userService.registerNewUser(user);
	}

	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only for Admin";
	}
	
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only for User";
	}

}
