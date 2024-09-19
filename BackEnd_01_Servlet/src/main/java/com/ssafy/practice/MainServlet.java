package com.ssafy.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;characterset=UTF-8"); // utf 8 로 변환해줘야 출력이 쉽다.
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("action");
		switch(action) {
		case "regist" :
			break;
			
		case "gugu" : 
			break;
		}
		
		
	}


}
