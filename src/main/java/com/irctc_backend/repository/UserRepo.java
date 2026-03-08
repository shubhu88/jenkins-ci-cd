package com.irctc_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc_backend.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String username);

}
