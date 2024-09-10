package cda.tpuserservice.config.jwt;


import cda.tpuserservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter
{
	final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserService userService;

	public JwtRequestFilter(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtTokenProvider jwtTokenProvider,
	                        UserService userService)
	{
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
		try
		{
			String token = getJWTFromHttpRequest(request);
			if (token != null && jwtTokenProvider.validateToken(token))
			{
				String userName = jwtTokenProvider.getUserNameFromToken(token);
				UserDetails userDetails = userService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken authenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			filterChain.doFilter(request, response);
		}
		catch (AuthenticationException e)
		{
			jwtAuthenticationEntryPoint.commence(request, response, e);
		}
	}

	private String getJWTFromHttpRequest(HttpServletRequest httpServletRequest)
	{
		String bearerToken = httpServletRequest.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer "))
		{
			return bearerToken.substring(7);
		}
		return null;
	}

}
