package project.assignment.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AssignmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentBackendApplication.class, args);
	}

}
