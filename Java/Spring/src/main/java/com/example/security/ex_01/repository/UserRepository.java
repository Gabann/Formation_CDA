package com.example.security.ex_01.repository;

import com.example.security.ex_01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{

	Optional<User> findByUsername(String username);
}
