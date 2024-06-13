package org.example.jee.ex_06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee.ex_05.dao.GenericDao;
import org.example.jee.ex_06.entity.User;
import org.example.jee.ex_06.utils.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "signupServlet", value = "/signupServlet")
public class SignupServlet extends HttpServlet
{
	GenericDao<User> userDao;

	@Override
	public void init() throws ServletException
	{
		userDao = new GenericDao<>(HibernateUtil.getSessionFactory(), User.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getRequestDispatcher("/pages/signupPage.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (username != null && email != null && password != null)
		{
			User user = new User(email, username, password);
			userDao.saveOrUpdate(user);
		}

		try
		{
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
