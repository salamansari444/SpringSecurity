package in.expleo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
	
	public String register(in.expleo.model.UserDetails details);
}
