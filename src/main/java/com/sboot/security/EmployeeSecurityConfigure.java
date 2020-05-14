package com.sboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class EmployeeSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	EmployeeUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new ApplicationUsernameAndPasswordFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.authorizeRequests()
		.antMatchers("/employees/employee-by-id/{empId}").permitAll()
		.antMatchers("/employees/all-employees").hasRole("USER")
		.anyRequest()
		.authenticated()
	;
		
		
		/*
		 * http.csrf().disable().authorizeRequests()
		 * .antMatchers("/employees/employee-by-id/{empId}").permitAll()
		 * .antMatchers("/employees/all-employees").hasAnyRole("USER")
		 * .anyRequest().authenticated() .and() .addFilter(new
		 * ApplicationUsernameAndPasswordFilter(authenticationManager())) .addFilter(new
		 * AuthorizationFilter(authenticationManager())).sessionManagement()
		 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and(). formLogin();
		 */

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	public ApplicationUsernameAndPasswordFilter getAuthenticationFiler() throws Exception {
		final ApplicationUsernameAndPasswordFilter filter = new ApplicationUsernameAndPasswordFilter(
				authenticationManager());
		filter.setFilterProcessesUrl("/ReportingApp-Department/login");
		return filter;
	}

}
