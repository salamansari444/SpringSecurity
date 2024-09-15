package in.expleo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguartion {
	public static final String GET ="GET";
	public static final String POST ="POST";
	public static final String DELETE ="DELETE";
	public static final String PUT ="PUT";
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods(GET,POST,DELETE, PUT)
				.allowedHeaders("*")
				.allowedOriginPatterns("*")
				.allowCredentials(true);
				
			}
		};
		
		
	}
}
