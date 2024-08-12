package com.example.aop.ex03.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
public class RequestFilter extends OncePerRequestFilter
{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		String requestIp = request.getRemoteAddr();
		String method = request.getMethod();
		String timestamp = String.valueOf(System.currentTimeMillis());
		Date date = new Date(Long.parseLong(timestamp));

		String currentDir = System.getProperty("user.dir");
		String filePath = currentDir + "/src/main/java/com/example/aop/ex03/filter/logs.txt";
		FileWriter fw = new FileWriter(filePath, true);
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Request from " + requestIp + " at " + date);
		bw.newLine();
		bw.write("URI: " + uri + " | Method: " + method);
		bw.newLine();
		bw.write("--------------------------------------------");
		bw.newLine();
		bw.close();

		filterChain.doFilter(request, response);
	}
}
