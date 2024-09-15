package in.expleo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigApp {
	
	@Autowired
	public void configSecurityApp(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sachin").password("{noop}sachin123").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh").roles("MANAGER");
	}
	
	@Bean
	public SecurityFilterChain configSecurity(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().
				antMatchers("/").permitAll().
				antMatchers("/loan").authenticated().
				antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER").anyRequest().authenticated().
				and().formLogin().and().rememberMe().and().logout().and().exceptionHandling();
				
		
		return http.build();
	}
}
