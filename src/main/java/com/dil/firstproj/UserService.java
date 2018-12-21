package com.dil.firstproj;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		if (!"error".equalsIgnoreCase(userName)) {
			return User.withDefaultPasswordEncoder()
					.username("dilshob")
					.password("test")
					.roles("test")
					.build();
			
		}
		return null;
	}

}
