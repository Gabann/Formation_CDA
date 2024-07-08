package com.example.mvc.ex_06;

import com.example.mvc.ex_06.model.User;
import com.example.mvc.ex_06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder)
	{
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUsername(username);
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername())
				//we add {noop} before the password to indicate that we are using plain text passwords
				.password("{noop}" + user.getPassword())
				.roles("USER")
				.build();
	}
}
