package org.example.jee.ex_06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee.ex_05.dao.GenericDao;
import org.example.jee.ex_06.entity.Product;
import org.example.jee.ex_06.utils.HibernateUtil;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productListServlet", value = "/secured/productListServlet")
public class ProductListServlet extends HttpServlet
{
	GenericDao<Product> productDao;
	List<Product> productList;

	@Override
	public void init() throws ServletException
	{
		productDao = new GenericDao<>(HibernateUtil.getSessionFactory(), Product.class);

		productList = productDao.getAll();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("product list");
		request.setAttribute("productList", productList);
		try
		{
			request.getRequestDispatcher("/pages/secured/productList.jsp").forward(request, response);
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
