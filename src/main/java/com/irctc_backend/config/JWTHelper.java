package com.irctc_backend.config;

import java.security.Key;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JWTHelper {

	private static final long JWT_VALIDITY = 5 * 60 * 1000;

	private final String SECRET = "feuyteutjbvdvbgfdhgfsdufeyrueytirtuefjdhfjdfhdavbznbvdsghefhaskc";

	private Key key;

	@PostConstruct
	public void init() {
		key = Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String generateToken(UserDetails userDetails) {

		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY))
				.signWith(key, SignatureAlgorithm.HS512).compact();
	}

	public String getUsernameFromToken(String token) {
		return getClaims(token).getSubject();
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {

		String userNameFromToken = getClaims(token).getSubject();
		String usernameFromUserDetails = userDetails.getUsername();

		Date expirationTime = getClaims(token).getExpiration();

		return userNameFromToken.equals(usernameFromUserDetails) && !isTokenExpired(expirationTime);
	}

	private boolean isTokenExpired(Date expirationTime) {

		return expirationTime.before(new Date());
	}

}
