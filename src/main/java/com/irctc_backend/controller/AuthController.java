package com.irctc_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc_backend.config.JWTHelper;
import com.irctc_backend.dto.LoginRequest;
import com.irctc_backend.service.UserService;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTHelper jwtHelper;

	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

		// token generate code
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					loginRequest.getUsername(), loginRequest.getPassword());

			this.authenticationManager.authenticate(authentication);

			// generate token
			UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
			String token = this.jwtHelper.generateToken(userDetails);
			String refreshToken = null;
			// User user = userRepo.findByEmail(loginRequest.username()).get();

//            JwtResponse jwtResponse = new JwtResponse(
//                    token,
//                    refreshToken,
//                    modelMapper.map(user, UserDto.class)
//            );

			// cookkie mein token ko bhej sakte hai.

			// set token cookie.

			return new ResponseEntity<>("", org.springframework.http.HttpStatus.OK);

		} catch (BadCredentialsException ex) {
			System.out.println("Invalid Credentials");
//            ErrorResponse errorResponse = new ErrorResponse(
//                    "The username or password you entered is incorrect.",
//                    "403",
//                    false
//            );

			return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> regesterUser(@RequestBody com.irctc_backend.model.User user){
		com.irctc_backend.model.User registerUser = userService.registerUser(user);
		return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
	}
	
}
