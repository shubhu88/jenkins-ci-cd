package com.irctc_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.irctc_backend.dto.CustomUserDetails;
import com.irctc_backend.repository.UserRepo;
import com.irctc_backend.util.ResourceNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//UserDetails user1 = User.builder().username("shubham").password("{noop}.shubh123").roles("USER").build();
		com.irctc_backend.model.User user = userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("Their is no user with this username.."));
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		return customUserDetails;
	}

}
