package org.example.jee.ex_04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatServlet", value = "/CatServlet")
public class CatServlet extends HttpServlet
{
	static List<Cat> catList = new ArrayList<>();

	@Override
	public void init() throws ServletException
	{

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));

		catList.add(new Cat(request.getParameter("name"), request.getParameter("species"), request.getParameter("favorite-meal"),
				dateOfBirth));

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
		request.setAttribute("catList", catList);
		try
		{
			getServletContext().getRequestDispatcher("/pages/ex_04/catList.jsp").forward(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}
}
