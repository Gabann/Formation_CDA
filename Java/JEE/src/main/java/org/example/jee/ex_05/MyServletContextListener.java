package org.example.jee.ex_05;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		System.out.println("Web application is starting up.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{

		System.out.println("Web application is shutting down.");
		releaseResources();
	}

	private void releaseResources()
	{
		System.out.println("Releasing resources.");
	}
}
