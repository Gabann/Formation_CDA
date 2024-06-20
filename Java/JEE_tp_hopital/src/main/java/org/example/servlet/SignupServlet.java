package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.GenericDao;
import org.example.entity.Admin;
import org.example.util.HibernateUtil;

import java.io.IOException;

@WebServlet(name = "signupServlet", value = "/signupServlet")
public class SignupServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getRequestDispatcher("/pages/signup.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || password == null)
		{
			return;
		}

		var adminDao = new GenericDao<Admin>(HibernateUtil.getSessionFactory(), Admin.class);

		Admin newAdmin = new Admin(username, password);
		adminDao.saveOrUpdate(newAdmin);

		try
		{
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
