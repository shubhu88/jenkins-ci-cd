package com.irctc_backend.config;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTHelper jwtHelper;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// har ek request se pahle.
		// cookie get karnge

		// Bearer 213534cdslkhfafjwfghjsfgopjfpk[f
		String authorizationHeader = request.getHeader("Authorization");

		// token get karnge cookie

		String username = null;
		String token = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			// Extracting the token from the header

			try {
				token = authorizationHeader.substring(7); // Remove "Bearer " prefix
				username = jwtHelper.getUsernameFromToken(token);

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

					if (jwtHelper.isTokenValid(token, userDetails)) {

						UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
								username, null, userDetails.getAuthorities());

						authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					}

				}
			} catch (ExpiredJwtException ex) {
				logger.error("JWT Token has expired");
				request.setAttribute("jwtExpiredError", "JWT expired");
				ex.printStackTrace();

			} catch (MalformedJwtException ex) {
				logger.error("Invalid JWT Token");
				ex.printStackTrace();

			} catch (IllegalArgumentException ex) {
				logger.error("Unable to get JWT Token : {}", ex);
				ex.printStackTrace();

			}

		} else {
			System.out.println("Invalid Authorization Header");
		}

		// ye request ko age bhej dega
		filterChain.doFilter(request, response);

	}
}