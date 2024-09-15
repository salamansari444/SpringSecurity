package in.expleo.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class configApp {

	public SecurityFilterChain getConfigApp(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.antMatchers("/","/home","/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()
		;
		
		
		return http.build();
	}
}
