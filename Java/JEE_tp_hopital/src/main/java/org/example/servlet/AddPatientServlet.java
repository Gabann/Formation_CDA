package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.dao.GenericDao;
import org.example.entity.Patient;
import org.example.util.HibernateUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddPatientServlet", value = "/AddPatientServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddPatientServlet extends HttpServlet
{
	static final String IMAGE_PATH = "/assets/images";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getRequestDispatcher("/pages/secured/addPatient.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		LocalDate birthDate = LocalDate.parse(request.getParameter("birth-date"));

		if (firstName == null || lastName == null || birthDate == null)
		{
			System.out.println("Missing post infos");
		}

		try
		{
			Part imagePart = request.getPart("photo");

			String uploadPath = getServletContext().getRealPath("") + IMAGE_PATH;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
			{
				uploadDir.mkdirs();
			}

			String filename = imagePart.getSubmittedFileName();
			imagePart.write(uploadPath + File.separator + filename);

			var patientDao = new GenericDao<Patient>(HibernateUtil.getSessionFactory(), Patient.class);


			Patient newPatient = new Patient(firstName, lastName, birthDate, filename);
			patientDao.saveOrUpdate(newPatient);

		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}


		try
		{
			response.sendRedirect(request.getContextPath() + "/PatientListServlet");
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
