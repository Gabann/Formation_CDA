package com.example.mvc.ex_06.repository;

import com.example.mvc.ex_06.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mvcUserRepository")
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsername(String username);
}
