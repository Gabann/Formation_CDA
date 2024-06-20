package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.GenericDao;
import org.example.entity.CareSheet;
import org.example.entity.Patient;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PatientDetails", value = "/patientDetails")
public class PatientDetailsServlet extends HttpServlet
{
	Long patientId;
	List<CareSheet> careSheetList;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		patientId = Long.valueOf(request.getParameter("id"));

		if (patientId == 0)
		{
			System.out.println("Missing id in url params");
			return;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		var careSheetDao = new GenericDao<CareSheet>(HibernateUtil.getSessionFactory(), CareSheet.class);
		Query<CareSheet> query = session.createNamedQuery("CareSheet.findByPatientId", CareSheet.class);
		query.setParameter("id", patientId);

		careSheetList = query.getResultList();


		request.setAttribute("careSheetList", careSheetList);

		try
		{
			request.getRequestDispatcher("/pages/secured/patientDetails.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String careType = request.getParameter("care-type");
		int durationDays = Integer.parseInt(request.getParameter("duration"));

		if (careType == null || durationDays == 0)
		{
			System.out.println("missing caretype or duration days");
		}

		var careSheetDao = new GenericDao<CareSheet>(HibernateUtil.getSessionFactory(), CareSheet.class);
		var patientDao = new GenericDao<Patient>(HibernateUtil.getSessionFactory(), Patient.class);

		Patient patient = patientDao.getById(patientId);
		CareSheet newCareSheet = new CareSheet(patient, durationDays, careType);

		careSheetDao.saveOrUpdate(newCareSheet);

		try
		{
			doGet(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
