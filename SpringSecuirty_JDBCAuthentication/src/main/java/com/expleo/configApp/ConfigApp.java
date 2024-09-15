package com.expleo.configApp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigApp {
	
	@Autowired
	public DataSource dataSource;
	
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().
		passwordEncoder(new BCryptPasswordEncoder()).
		dataSource(dataSource).
		usersByUsernameQuery("select username,password,enabled from usersa where username=?").
		authoritiesByUsernameQuery("select username,role from authority where username=?");
	}
	
	@Bean
	public SecurityFilterChain getAuthenticationAPI(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(request -> request.antMatchers("/api/")
				.permitAll()
				.antMatchers("/api/admin/").hasRole("ADMIN")
				.antMatchers("/api/user/").hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated()
				).formLogin();
		
		
		return http.build();
	}

}
