package in.expleo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.expleo.entity.Role;
import in.expleo.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@PostMapping("/createNewRole")
	public ResponseEntity<Role> createNewRole( @RequestBody Role role) {
		 Role saveRole = service.crateNewRole(role);
		 return new ResponseEntity<Role>(saveRole,HttpStatus.OK);
	}
}
