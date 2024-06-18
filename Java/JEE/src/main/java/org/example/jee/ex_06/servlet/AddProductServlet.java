package org.example.jee.ex_06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.jee.ex_05.dao.GenericDao;
import org.example.jee.ex_06.entity.Product;
import org.example.jee.ex_06.utils.HibernateUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addProductServlet", value = "/secured/addProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddProductServlet extends HttpServlet
{
	static final String IMAGE_PATH = "/assets/images";
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
				Part imagePart = request.getPart("image");

				String uploadPath = getServletContext().getRealPath("") + IMAGE_PATH;
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists())
				{
					uploadDir.mkdirs();
				}

				String filename = imagePart.getSubmittedFileName();
				imagePart.write(uploadPath + File.separator + filename);

				Product newProduct = new Product(brand, reference, purchaseDate, price, stock, filename);
				productDao.saveOrUpdate(newProduct);
			}


			response.sendRedirect(request.getContextPath() + "/secured/productListServlet");
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
