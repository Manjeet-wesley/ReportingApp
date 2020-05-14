package com.sboot.security;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sboot.SpringApplicationContext;
import com.sboot.client.user.ClientUserRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ApplicationUsernameAndPasswordFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	
	public ApplicationUsernameAndPasswordFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response)
			throws AuthenticationException {
		try {
			ClientUserRequest userRequest=new ObjectMapper().readValue(request.getInputStream(),ClientUserRequest.class);
			Authentication authentication=new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getPassword());
			
			return authenticationManager.authenticate(authentication);
		} catch (IOException e) {
			throw new RuntimeException("Such client is not exist");			
		}
		
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			                               HttpServletResponse response,
			                               FilterChain chain,
			                               Authentication authResult) throws IOException, ServletException {
		String token=Jwts.builder()
		.setSubject(authResult.getName())
		.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(4)))
		.signWith(SignatureAlgorithm.HS256,ApplicationSecurityConstant.getApplicationSecurityToken())
		.compact();
		
		response.addHeader(ApplicationSecurityConstant.HEADER_PREFIX, ApplicationSecurityConstant.TOKEN_PREFIX+" "+token);
		
	}
	
	
	

	
}
