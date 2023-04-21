package com.NGCPrompt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.NGCPrompt.todo")
public class NgcPromptApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgcPromptApplication.class, args);
		
	}


}
