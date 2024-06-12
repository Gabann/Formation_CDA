package org.example.jee.ex_05.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee.ex_05.dao.GenericDao;
import org.example.jee.ex_05.entity.Dog;
import org.example.jee.ex_05.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "dogDetailsServlet", value = {"/dogDetailsServlet/*"})
public class DogDetailsServlet extends HttpServlet
{
	GenericDao<Dog> dogDao;

	@Override
	public void init() throws ServletException
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		dogDao = new GenericDao<>(sessionFactory, Dog.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Dog dog;
		String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";
		Long id;
		id = Long.parseLong(pathInfo.substring(1));
		dog = dogDao.getById(id);
		request.setAttribute("dog", dog);
		System.out.println(dog);
		request.setAttribute("pathInfo", pathInfo);

		request.getRequestDispatcher("/pages/dogDetails.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
