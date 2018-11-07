package heb.Candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import heb.Candidate.HEBConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration
//@Configuration
//@Component

public class CandidateApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CandidateApplication.class, args);
		SpringApplication.run(HEBConfiguration.class, args);
	}


}
