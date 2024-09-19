package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet2 extends GenericServlet { // 추상 클래스로, 나머지는 전부 갖고 있다는 뜻이다. 

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 요청과 응답만 구현하면 된다. 
		
	}

}
