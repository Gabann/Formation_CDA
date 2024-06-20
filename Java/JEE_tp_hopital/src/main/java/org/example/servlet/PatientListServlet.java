package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.GenericDao;
import org.example.entity.Patient;
import org.example.util.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PatientListServlet", value = "/PatientListServlet")
public class PatientListServlet extends HttpServlet
{
	List<Patient> patientList;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		var patientDao = new GenericDao<Patient>(HibernateUtil.getSessionFactory(), Patient.class);
		patientList = patientDao.getAll();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("patientList", patientList);

		try
		{
			request.getRequestDispatcher("/pages/secured/patientList.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
