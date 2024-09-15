package in.expleo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringDataJpaSecurityAppApplication {
	
	@Bean
	public BCryptPasswordEncoder enocder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSecurityAppApplication.class, args);
	}

}
