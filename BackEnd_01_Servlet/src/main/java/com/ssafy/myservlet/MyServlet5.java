package com.ssafy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet5")
public class MyServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();

		//Java 15 버전에 나온 Block String
		writer.write("""
					<html>
					  <head><title>Hello! SSAFY!</title></head>
					  <body>
					    <h1>Hello! Servlet5!</h1>
					  </body>
					</html>
					""");
		// 하나의 서블릿은 여러 경로를 가질 수 있지만, 하나의 경로는 하나의 서블릿만 가져야 한다. 
	}
}


