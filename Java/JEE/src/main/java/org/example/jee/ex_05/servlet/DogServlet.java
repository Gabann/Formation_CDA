package org.example.jee.ex_05.servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee.ex_05.dao.GenericDao;
import org.example.jee.ex_05.entity.Dog;
import org.example.jee.ex_05.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebListener
@WebServlet(name = "DogServlet", value = "/DogServlet")
public class DogServlet extends HttpServlet implements ServletContextListener
{
	List<Dog> dogList;
	GenericDao<Dog> dogDao;

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		ServletContextListener.super.contextInitialized(sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		for (Dog dog : dogList)
		{
			dogDao.saveOrUpdate(dog);
		}
	}

	@Override
	public void init() throws ServletException
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		dogDao = new GenericDao<>(sessionFactory, Dog.class);
		dogList = dogDao.getAll();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("dogList", dogList);
		request.getRequestDispatcher("/pages/dogList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));
		Dog dog = new Dog(request.getParameter("name"), request.getParameter("breed"), dateOfBirth);

		dogList.add(dog);
		dogDao.saveOrUpdate(dog);

		try
		{
			doGet(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
