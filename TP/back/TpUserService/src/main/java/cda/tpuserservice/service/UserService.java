package cda.tpuserservice.service;

import cda.tpuserservice.config.jwt.JwtTokenProvider;
import cda.tpuserservice.entity.User;
import cda.tpuserservice.repository.UserRepository;
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

import java.util.List;

@Service
public class UserService implements UserDetailsService
{
	private final PasswordEncoder passwordEncoder;

	private final UserRepository repository;

	private final JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenProvider jwtTokenProvider)
	{
		this.passwordEncoder = passwordEncoder;
		this.repository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	public String generateToken(String username, String password)
	{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtTokenProvider.generateToken(authentication);
	}

	public User getById(Long id)
	{
		return repository.findById(id).orElse(null);
	}

	public User create(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public List<User> getAll()
	{
		return repository.findAll();
	}

	public boolean deleteById(Long id)
	{
		if (repository.findById(id).isPresent())
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean updateById(Long id, User newUser)
	{
		User existingUser = repository.findById(id).orElse(null);
		if (existingUser == null)
		{
			return false;
		}
		else
		{
			newUser.setId(id);
			repository.save(newUser);
			return true;
		}
	}

	public boolean doesEmailExists(String email)
	{
		return (repository.findByEmail(email).isPresent());
	}

	public boolean verifyCredentials(String username, String password)
	{
		return repository.findByEmail(username).map(user -> passwordEncoder.
				matches(password, user.getPassword())).orElseThrow(() -> new UsernameNotFoundException(" User Not Found "));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}
}
