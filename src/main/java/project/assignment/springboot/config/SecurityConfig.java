package project.assignment.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

//to indicate there are one or more bean methods  for process by spring container
public class SecurityConfig {

	@Bean//it produces bean to get managed by spring container
	public PasswordEncoder passwordEncoder() {
		 //PasswordEncoder service interface to encode passwords by BCryptPasswordEncoder
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

		
	}
	

