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
import java.time.LocalDate;

@WebServlet(name = "addProductServlet", value = "/secured/addProductServlet")
public class AddProductServlet extends HttpServlet
{
	GenericDao<Product> productDao;

	@Override
	public void init() throws ServletException
	{
		productDao = new GenericDao<>(HibernateUtil.getSessionFactory(), Product.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getRequestDispatcher("/pages/ex_06/secured/addProduct.jsp").forward(request, response);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String brand = request.getParameter("brand");
		String reference = request.getParameter("reference");
		LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchase-date"));
		try
		{
			double price = Double.parseDouble(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));

			if (brand != null && reference != null && purchaseDate != null)
			{
				Product newProduct = new Product(brand, reference, purchaseDate, price, stock);
				productDao.saveOrUpdate(newProduct);
			}
			response.sendRedirect("./pages/ex_06/secured/productList.jsp");
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
