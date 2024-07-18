package com.example.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
	{
		return authenticationConfiguration.getAuthenticationManager();
	}

//	@Bean
//	public AuthenticationManager authenticationManager(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder)
//	{
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//
//		return new ProviderManager(daoAuthenticationProvider);
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
				.authorizeHttpRequests(authorize -> authorize
								.requestMatchers("/forum/**").authenticated()
								.requestMatchers("/api/auth/**").permitAll()
								.requestMatchers("/api/products").hasAnyRole("USER", "ADMIN")
								.requestMatchers("/api/products/admin/create").hasRole("ADMIN")
//						.requestMatchers("*").authenticated()
								.anyRequest().permitAll()
				)
				.formLogin(form -> form
						.loginPage("/forum/login")
						.loginProcessingUrl("/forum/login")
						.defaultSuccessUrl("/forum/secured", true)
						.failureUrl("/forum/login?error=true")
						.permitAll()
				)
				.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(Customizer.withDefaults())
				.logout(LogoutConfigurer::permitAll);

		return http.build();
	}
}
