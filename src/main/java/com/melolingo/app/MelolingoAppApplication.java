package com.melolingo.app;

import com.melolingo.app.models.Role;
import com.melolingo.app.repo.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.melolingo.app.services", "com.melolingo.app.controller", "com.melolingo.app.security"})
public class MelolingoAppApplication implements CommandLineRunner {
	private final RoleRepo roleRepo;

	public MelolingoAppApplication(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(MelolingoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create default role if nonexistent
		if (roleRepo.findByName(Role.ERole.ROLE_USER) == null) {
			Role userRole = new Role(Role.ERole.ROLE_USER);
			roleRepo.save(userRole);
		}
	}
}
