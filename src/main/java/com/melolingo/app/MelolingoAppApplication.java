package com.melolingo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.melolingo.app.services", "com.melolingo.app.controller", "com.melolingo.app.security"})
public class MelolingoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelolingoAppApplication.class, args);
	}

}
