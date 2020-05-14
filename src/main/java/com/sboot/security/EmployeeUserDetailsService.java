package com.sboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sboot.entity.User;
import com.sboot.repository.UserRepository;


@Service
public class EmployeeUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userrepo.findByUsername(username);
		
				user.orElseThrow(()->new UsernameNotFoundException("User Not found "+username));
				System.out.println("===================="+user.get());
		return user.map(MyUserDetails::new).get();
	}

} 
