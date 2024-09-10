package cda.tpuserservice.controller;

import cda.tpuserservice.dto.LoginDto;
import cda.tpuserservice.entity.User;
import cda.tpuserservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{
	private final UserService service;

	public UserController(UserService service)
	{
		this.service = service;
	}

	@GetMapping("/all")
	public List<User> getAllUsers()
	{
		return service.getAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id)
	{
		return service.getById(id);
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return service.create(user);
	}

	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable Long id)
	{
		return service.deleteById(id);
	}

	@PutMapping("/{id}")
	public boolean updateUser(@PathVariable Long id, @RequestBody User user)
	{
		return service.updateById(id, user);
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto)
	{
		if (!service.doesEmailExists(loginDto.getEmail())
				|| !service.verifyCredentials(loginDto.getEmail(), loginDto.getPassword()))
		{
			return "Wrong email or password";
		}

		return service.generateToken(loginDto.getEmail(), loginDto.getPassword());
	}
}
