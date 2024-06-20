package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.GenericDao;
import org.example.entity.CareSheet;
import org.example.entity.Meds;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "CareSheetDetails", value = "/careSheetDetails")
public class CareSheetDetailsServlet extends HttpServlet
{
	Long careSheetId;
	List<Meds> medsList;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		careSheetId = Long.valueOf(request.getParameter("id"));

		if (careSheetId == 0)
		{
			System.out.println("Missing id in url params");
			return;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		var medsDao = new GenericDao<Meds>(HibernateUtil.getSessionFactory(), Meds.class);
		Query<Meds> query = session.createNamedQuery("Meds.findByCareSheets_Id", Meds.class);
		query.setParameter("id", careSheetId);

		medsList = query.getResultList();

		request.setAttribute("medsList", medsList);

		try
		{
			request.getRequestDispatcher("/pages/secured/careSheetDetails.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String medsType = request.getParameter("meds-type");
		int durationDays = Integer.parseInt(request.getParameter("duration"));

		if (medsType == null || durationDays == 0)
		{
			System.out.println("missing medsType or duration days");
		}

		var medsDao = new GenericDao<Meds>(HibernateUtil.getSessionFactory(), Meds.class);
		var careSheetDao = new GenericDao<CareSheet>(HibernateUtil.getSessionFactory(), CareSheet.class);

		CareSheet careSheet = careSheetDao.getById(careSheetId);
		Meds newMeds = new Meds(medsType, durationDays, Set.of(careSheet));

		medsDao.saveOrUpdate(newMeds);

		try
		{
			doGet(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}
}
