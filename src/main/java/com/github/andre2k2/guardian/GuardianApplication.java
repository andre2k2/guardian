package com.github.andre2k2.guardian;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuardianApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuardianApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GuardianRunner guardianRunner) {
		return guardianRunner::run;
	}
}
