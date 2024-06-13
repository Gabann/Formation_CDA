package org.example.jee.ex_06.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AuthFilterServlet", value = "/AuthFilterServlet")
public class AuthFilterServlet extends HttpServlet implements Filter
{
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		Cookie[] cookies = request.getCookies();
		boolean isLogged = false;

		if (cookies != null)
		{
			for (Cookie cookie : cookies)
			{
				if (cookie.getName().equals("isLogged"))
				{
					isLogged = true;
					break;
				}
			}
		}

		if (!isLogged)
		{
			System.out.println("Not logged and trying to access secured page");
			try
			{
				((HttpServletResponse) servletResponse).sendRedirect("../pages/login.jsp");
			} catch (Exception e)
			{
				System.out.println("Something went wrong: " + e);
			}

		}
		else
		{
			try
			{
				chain.doFilter(servletRequest, servletResponse);
			} catch (Exception e)
			{
				System.out.println("Something went wrong: " + e);
			}

		}
	}
}
