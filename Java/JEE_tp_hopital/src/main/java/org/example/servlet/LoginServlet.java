package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.GenericDao;
import org.example.entity.Admin;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet
{

	void refreshPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			doGet(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
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
			refreshPage(request, response);
			return;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		var adminDao = new GenericDao<Admin>(HibernateUtil.getSessionFactory(), Admin.class);
		Query<Admin> query = session.createNamedQuery("Admin.findByUsername", Admin.class);
		query.setParameter("username", username);

		Admin foundAdmin = null;
		//TODO make the username unique in the bdd and use getSingleResult() instead
		List<Admin> admins = query.getResultList();

		if (admins.isEmpty())
		{
			System.out.printf("Admin with username %s not found%n", username);
			refreshPage(request, response);
			return;
		}

		foundAdmin = admins.get(0);

		if (!foundAdmin.getPassword().equals(password))
		{
			System.out.println("Username or password incorrect");
			refreshPage(request, response);
			return;
		}

		Cookie loggedCookie = new Cookie("isLogged", "true");
		loggedCookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(loggedCookie);

		try
		{
			request.getRequestDispatcher("/pages/secured/patientList.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
