package org.example.jee.ex_06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee.ex_06.entity.User;
import org.example.jee.ex_06.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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

		if (isLogged)
		{
			System.out.println("already logged in");
			try
			{
				response.sendRedirect("./pages/secured/productList.jsp");
			} catch (Exception e)
			{
				System.out.println("Something went wrong: " + e);
			}

		}
		else
		{
			try
			{
				request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			} catch (Exception e)
			{
				System.out.println("Something went wrong: " + e);
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null && password != null)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query<User> query = session.createNamedQuery("User.findByUsername", User.class);
			query.setParameter("username", username);

			User foundUser = null;
			try
			{
				foundUser = query.getSingleResult();
			} catch (Exception e)
			{
				System.out.println("Something went wrong: " + e);
			}

			if (foundUser == null || !foundUser.getPassword().equals(password))
			{
				System.out.println("Wrong username or password");
				try
				{
					doGet(request, response);
				} catch (Exception e)
				{
					System.out.println("Something went wrong: " + e);
				}

			}
			else
			{
				System.out.println("Connected");
				Cookie cookie = new Cookie("isLogged", "true");
				cookie.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(cookie);
				try
				{
					response.sendRedirect("./pages/secured/productList.jsp");
				} catch (Exception e)
				{
					System.out.println("Something went wrong: " + e);
				}

			}
		}
	}
}
