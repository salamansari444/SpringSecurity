package in.expleo.configApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Bean
	public SecurityFilterChain configSecurityMethod(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().antMatchers("/bank/").permitAll()
		.antMatchers("/user/register", "/user/showLogin").permitAll()
		.antMatchers("/bank/offers").authenticated()
		.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")
		.antMatchers("/bank/loanApprove").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		
		.and().formLogin()
		.defaultSuccessUrl("/bank/", true)  //home page url
		.loginPage("/user/showLogin")       //for GET Mode request to launch form page
		.loginProcessingUrl("/login")       //for POST Mode request to submit and process the page
		.failureUrl("/user/showLogin?error")//Authentication failed URL
		
		.and().rememberMe()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.logoutSuccessUrl("/user/showLogin?logout")
		
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(5).maxSessionsPreventsLogin(true);

		return http.build();
	}

}
