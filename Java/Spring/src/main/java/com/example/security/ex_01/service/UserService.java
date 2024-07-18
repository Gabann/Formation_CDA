package com.example.security.ex_01.service;


import com.example.config.jwt.JwtTokenProvider;
import com.example.security.ex_01.entity.User;
import com.example.security.ex_01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
//	final PasswordEncoder passwordEncoder;
//	final UserRepository userRepository;
//
//	@Lazy
//	final AuthenticationManager authenticationManager;
//
//	final JwtTokenProvider jwtTokenProvider;
//
//	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager,
//	                   JwtTokenProvider jwtTokenProvider)
//	{
//		this.passwordEncoder = passwordEncoder;
//		this.userRepository = userRepository;
//		this.authenticationManager = authenticationManager;
//		this.jwtTokenProvider = jwtTokenProvider;
//	}

	private final PasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenProvider jwtTokenProvider)
	{
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	public String generateToken(String username, String password)
	{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtTokenProvider.generateToken(authentication);
	}

	public boolean doesUsernameExists(String username)
	{
		return (userRepository.findByUsername(username).isPresent());
	}

	public boolean createUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return true;
	}

	public boolean verifyUser(String username, String password)
	{
		return userRepository.findByUsername(username).map(user -> passwordEncoder.
				matches(password, user.getPassword())).orElseThrow(() -> new UsernameNotFoundException(" User Not Found "));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}
}
