package com.irctc_backend.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.irctc_backend.model.Role;
import com.irctc_backend.model.User;
import com.irctc_backend.repository.RoleRepo;
import com.irctc_backend.repository.UserRepo;
import com.irctc_backend.util.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(User user) {
		Role role = roleRepo.findByName("ROLE_NORMAL").orElseThrow(() -> new ResourceNotFoundException("Server issue"));
		user.getRoles().add(role);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedAt(LocalDateTime.now());
		User savedUser = userRepo.save(user);
		return savedUser;
	}

}
