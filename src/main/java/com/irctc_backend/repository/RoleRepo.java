package com.irctc_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc_backend.model.Role;
import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, String>{
	
	Optional<Role>  findByName(String name);
	
	boolean existsByName(String name);

}
