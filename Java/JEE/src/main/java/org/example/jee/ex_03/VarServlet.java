package org.example.jee.ex_03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VarServlet", value = "/VarServlet")
public class VarServlet extends HttpServlet
{
	static List<Person> personList = new ArrayList<>();

	@Override
	public void init() throws ServletException
	{
		personList.add(new Person("Doe", "John", 30));
		personList.add(new Person("Doe", "Jane", 25));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("personList", personList);
		try
		{
			getServletContext().getRequestDispatcher("/pages/ex_03/personList.jsp").forward(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
