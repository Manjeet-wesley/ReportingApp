package com.sboot.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header=request.getHeader(ApplicationSecurityConstant.HEADER_PREFIX);

		if(header==null || !header.startsWith(ApplicationSecurityConstant.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return ;
		}
		UsernamePasswordAuthenticationToken usernamepasswordAuthenticationtoken=getUsernamePasswordAuthenticationToken(request);
		
		SecurityContextHolder.getContext().setAuthentication(usernamepasswordAuthenticationtoken);
		
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(HttpServletRequest request) {
		String token=request.getHeader(ApplicationSecurityConstant.HEADER_PREFIX);
		
		if(token!=null) {
			token=token.replace(ApplicationSecurityConstant.TOKEN_PREFIX, "");
			
			String user=Jwts.parser()
			.setSigningKey(ApplicationSecurityConstant.getApplicationSecurityToken())
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			
			if(user!=null) {
				return new UsernamePasswordAuthenticationToken(user, null,new ArrayList<>());
			}
			return null;
		}
		return null;
	}
	
	

	
	
}
