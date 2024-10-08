package cda.tpuserservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails
{
	@Column(name = "email", nullable = false, unique = true)
	String email;
	@Column(name = "password", nullable = false)
	String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String roles = "user";

	private boolean isEnabled = true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Arrays
				.stream(roles.split(","))
				.map(SimpleGrantedAuthority::new)
				.toList();
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return email;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return UserDetails.super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return UserDetails.super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return UserDetails.super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled()
	{
		return isEnabled;
	}
}
