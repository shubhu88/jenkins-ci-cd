package com.irctc_backend;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.irctc_backend.model.Role;
import com.irctc_backend.repository.RoleRepo;

@SpringBootApplication
public class IrctcBackendXxApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IrctcBackendXxApplication.class, args);
	}
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		if(roleRepo.existsByName("ROLE_ADMIN")) {
			Role role = new Role();
			role.setId(UUID.randomUUID().toString());
			role.setName("ROLE_ADMIN");
			roleRepo.save(role);
		}
		
		if(roleRepo.existsByName("ROLE_NORMAL")) {
			Role role = new Role();
			role.setId(UUID.randomUUID().toString());
			role.setName("ROLE_NORMAL");
			roleRepo.save(role);
		}
		
	}

}
